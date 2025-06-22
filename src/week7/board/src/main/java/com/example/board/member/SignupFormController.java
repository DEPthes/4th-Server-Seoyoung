package com.example.board.member;

import com.example.board.member.MemberService;
import com.example.board.member.dto.MemberJoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupFormController {

    private final MemberService memberService;

    // GET 요청: 회원가입 페이지 렌더링
    @GetMapping
    public String signupForm(Model model) {
        model.addAttribute("member", new MemberJoinRequest());
        return "signup";
    }

    // POST 요청: 폼으로부터 받은 데이터를 처리
    @PostMapping
    public String signupSubmit(@ModelAttribute("member") MemberJoinRequest request) {
        memberService.register(request);
        return "redirect:/login";
    }
}
