package com.example.board.post;

import com.example.board.member.MemberEntity;
import com.example.board.member.MemberRepository;
import com.example.board.post.dto.PostRequestDto;
import com.example.board.post.dto.PostResponseDto;
import com.example.board.security.CustomOAuth2User;
import com.example.board.security.CustomUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts")
public class PostApiController {

    private final PostService postService;
    private final MemberRepository memberRepository;

    public PostApiController(PostService postService, MemberRepository memberRepository) {
        this.postService = postService;
        this.memberRepository = memberRepository;
    }

    // 게시글 목록 API (GET)
    @GetMapping
    public List<PostResponseDto> getAllPosts(@AuthenticationPrincipal Object principal) {
        Long currentUserId = null;

        if (principal instanceof CustomUserDetails customUser) {
            currentUserId = memberRepository.findByEmail(customUser.getUsername())
                    .map(MemberEntity::getId)
                    .orElse(null);
        } else if (principal instanceof CustomOAuth2User oauthUser) {
            currentUserId = memberRepository.findByEmail(oauthUser.getEmail())
                    .map(MemberEntity::getId)
                    .orElse(null);
        }

        // 여기서 final로 복사
        final Long finalCurrentUserId = currentUserId;

        return postService.getAllPosts()
                .stream()
                .map(post -> new PostResponseDto(post,
                        finalCurrentUserId != null && post.getMember().getId().equals(finalCurrentUserId)))
                .collect(Collectors.toList());
    }


    // 내가 쓴 게시글 조회
    @GetMapping("/mine")
    public List<PostResponseDto> getMyPosts(@AuthenticationPrincipal Object principal) {
        MemberEntity member = getAuthenticatedMember(principal);

        return postService.getPostsByMemberEmail(member.getEmail())
                .stream()
                .map(post -> new PostResponseDto(post, true))  // 무조건 본인 글이니까 true
                .collect(Collectors.toList());
    }



    // 게시글 작성 API
    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto postRequestDto,
                                                 @AuthenticationPrincipal Object principal) {

        MemberEntity member = getAuthenticatedMember(principal);
        PostEntity post = new PostEntity();
        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());
        post.setMember(member);

        postService.savePost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PostResponseDto(post,true));
    }

    // 게시글 수정 API (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        PostEntity existingPost = postService.getPostById(id);
        existingPost.setTitle(postRequestDto.getTitle());
        existingPost.setContent(postRequestDto.getContent());
        postService.updatePost(id, existingPost);

        return ResponseEntity.ok(new PostResponseDto(existingPost, true));
    }

    // 인증된 사용자 가져오기
    private MemberEntity getAuthenticatedMember(Object principal) {
        MemberEntity member;

        if (principal instanceof CustomUserDetails customUser) {
            // 일반 로그인 사용자
            String email = customUser.getUsername();
            member = memberRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("회원 정보 없음"));
        } else if (principal instanceof CustomOAuth2User oauthUser) {
            // 소셜 로그인 사용자
            String email = oauthUser.getEmail();
            member = memberRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("소셜 사용자 없음"));
        } else {
            throw new RuntimeException("인증되지 않은 사용자");
        }

        return member;
    }

    //게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id,
                                        @AuthenticationPrincipal Object principal) {
        PostEntity post = postService.getPostById(id);
        MemberEntity currentUser = getAuthenticatedMember(principal);

        if (!post.getMember().getId().equals(currentUser.getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("본인만 삭제할 수 있습니다.");
        }

        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    // 게시글 세부 조회 API
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long id,
                                                   @AuthenticationPrincipal Object principal) {
        PostEntity post = postService.getPostById(id);
        MemberEntity member = getAuthenticatedMember(principal);
        boolean mine = post.getMember().getId().equals(member.getId());

        return ResponseEntity.ok(new PostResponseDto(post, mine));
    }




}
