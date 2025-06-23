package com.example.board.comment;

import com.example.board.member.MemberEntity;
import com.example.board.member.MemberRepository;
import com.example.board.post.PostEntity;
import com.example.board.post.PostRepository;
import com.example.board.security.CustomOAuth2User;
import com.example.board.security.CustomUserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public CommentService(CommentRepository commentRepository,
                          PostRepository postRepository,
                          MemberRepository memberRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }
    // 댓글 저장
    public CommentEntity saveComment(CommentEntity comment) {
        return commentRepository.save(comment);
    }

    // 특정 게시글의 댓글 조회
    public List<CommentEntity> getCommentsByPost(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public CommentEntity saveComment(Long postId, MemberEntity member, String content) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));

        CommentEntity comment = new CommentEntity();
        comment.setPost(post);
        comment.setMember(member);
        comment.setContent(content);
        comment.setCreatedAt(LocalDateTime.now());

        return commentRepository.save(comment);
    }

    public MemberEntity getAuthenticatedMember(Object principal) {
        if (principal instanceof CustomUserDetails customUser) {
            return memberRepository.findByEmail(customUser.getUsername())
                    .orElseThrow(() -> new RuntimeException("회원 정보 없음"));
        } else if (principal instanceof CustomOAuth2User oauthUser) {
            return memberRepository.findByEmail(oauthUser.getEmail())
                    .orElseThrow(() -> new RuntimeException("소셜 사용자 없음"));
        } else {
            throw new RuntimeException("인증되지 않은 사용자");
        }
    }

    @Transactional
    public CommentEntity updateComment(Long commentId, MemberEntity member, String content) {
        CommentEntity comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("댓글이 존재하지 않습니다."));

        if (!comment.getMember().getId().equals(member.getId())) {
            throw new RuntimeException("본인 댓글만 수정할 수 있습니다.");
        }

        comment.setContent(content);
        comment.setUpdatedAt(LocalDateTime.now());
        return comment;
    }



    // 댓글 삭제
    public void deleteComment(Long commentId, MemberEntity member) {
        CommentEntity comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));

        if (!comment.getMember().getId().equals(member.getId())) {
            throw new RuntimeException("본인의 댓글만 삭제할 수 있습니다.");
        }

        commentRepository.delete(comment);
    }


}
