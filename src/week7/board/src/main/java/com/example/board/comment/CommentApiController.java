package com.example.board.comment;

import com.example.board.comment.dto.CommentRequestDto;
import com.example.board.comment.dto.CommentResponseDto;
import com.example.board.member.MemberEntity;
import com.example.board.security.CustomOAuth2User;
import com.example.board.security.CustomUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comments")
public class CommentApiController {

    private final CommentService commentService;

    public CommentApiController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 게시글 ID로 댓글 목록 조회
    @GetMapping("/post/{postId}")
    public List<CommentResponseDto> getCommentsByPost(@PathVariable Long postId,
                                                      @AuthenticationPrincipal Object principal) {
        MemberEntity loginUser = getAuthenticatedMember(principal);
        return commentService.getCommentsByPost(postId).stream()
                .map(comment -> new CommentResponseDto(comment,
                        comment.getMember().getId().equals(loginUser.getId())))
                .collect(Collectors.toList());
    }

    private MemberEntity getAuthenticatedMember(Object principal) {
        if (principal instanceof CustomUserDetails userDetails) {
            return userDetails.getMember();
        } else if (principal instanceof CustomOAuth2User oAuth2User) {
            return oAuth2User.getMember();
        } else {
            throw new IllegalStateException("알 수 없는 사용자 인증 방식");
        }
    }


    //댓글작성
    @PostMapping("/post/{postId}")
    public ResponseEntity<CommentResponseDto> createComment(@PathVariable Long postId,
                                                            @RequestBody CommentRequestDto dto,
                                                            @AuthenticationPrincipal Object principal) {
        MemberEntity member = commentService.getAuthenticatedMember(principal);
        CommentEntity comment = commentService.saveComment(postId, member, dto.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommentResponseDto(comment,true));
    }

    //댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable Long commentId,
                                                            @RequestBody CommentRequestDto dto,
                                                            @AuthenticationPrincipal Object principal) {
        MemberEntity member = commentService.getAuthenticatedMember(principal);
        CommentEntity comment = commentService.updateComment(commentId, member, dto.getContent());
        return ResponseEntity.ok(new CommentResponseDto(comment,true));
    }

    //댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId,
                                              @AuthenticationPrincipal Object principal) {
        MemberEntity member = commentService.getAuthenticatedMember(principal);
        commentService.deleteComment(commentId, member);
        return ResponseEntity.noContent().build();
    }



}
