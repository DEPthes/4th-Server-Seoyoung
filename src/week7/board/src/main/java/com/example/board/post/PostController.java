package com.example.board.post;

import com.example.board.member.MemberRepository;
import com.example.board.security.CustomUserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final MemberRepository memberRepository;

    public PostController(PostService postService, MemberRepository memberRepository) {
        this.postService = postService;
        this.memberRepository = memberRepository;
    }

    //  전체 게시글 목록 페이지
    @GetMapping
    public String getAllPosts(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<PostEntity> postPage = postService.getAllPosts(pageable);

        model.addAttribute("postPage", postPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", postPage.getTotalPages());

        return "postList";
    }

    // 게시글 작성 폼 페이지
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new PostEntity());
        return "createPost";
    }

    // 로그인한 사용자의 게시글 목록
    @GetMapping("/mine")
    public String getMyPosts(Model model, @AuthenticationPrincipal Object principal) {
        String email = extractEmail(principal);
        model.addAttribute("myPosts", postService.getPostsByMemberEmail(email));
        return "myPosts";
    }

    // 게시글 수정 폼 페이지
    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "editPost";
    }

    private String extractEmail(Object principal) {
        if (principal instanceof CustomUserDetails customUser) {
            return customUser.getUsername();
        } else if (principal instanceof OAuth2User oauthUser) {
            Map<String, Object> attributes = oauthUser.getAttributes();
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");

            if (kakaoAccount != null && kakaoAccount.get("email") != null) {
                return kakaoAccount.get("email").toString();
            }
        }

        throw new RuntimeException("이메일 정보를 찾을 수 없습니다.");
    }


    // 각 게시글 조회 페이지 (뷰만 리턴)
    @GetMapping("/{id}")
    public String getPostDetailPage() {
        return "postDetail"; // 화면만 반환, 데이터는 JS가 fetch로 로딩
    }




}