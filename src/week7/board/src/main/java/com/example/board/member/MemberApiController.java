package com.example.board.member;

import com.example.board.member.dto.MemberSummaryDto;
import com.example.board.security.CustomOAuth2User;
import com.example.board.security.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberApiController {

    private final MemberRepository memberRepository;

    public MemberApiController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/me")
    public MemberSummaryDto getCurrentUser(@AuthenticationPrincipal Object principal) {
        String email;

        if (principal instanceof CustomUserDetails customUser) {
            email = customUser.getUsername();
        } else if (principal instanceof CustomOAuth2User oauthUser) {
            email = oauthUser.getEmail();
        } else {
            throw new RuntimeException("인증되지 않은 사용자입니다.");
        }

        MemberEntity member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("사용자 정보를 찾을 수 없습니다."));

        return new MemberSummaryDto(member.getEmail(), member.getNickname());
    }
}
