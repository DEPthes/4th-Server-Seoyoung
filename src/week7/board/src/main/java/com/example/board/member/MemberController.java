package com.example.board.member;

import com.example.board.member.dto.MemberJoinRequest;
import com.example.board.member.dto.MemberResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입
    @PostMapping
    public MemberResponse register(@RequestBody MemberJoinRequest request) {
        var savedMember = memberService.register(request);
        return new MemberResponse(savedMember);
    }

    // 내 정보 조회 (임시)
    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        var member = memberService.getById(id);
        return new MemberResponse(member);
    }
}
