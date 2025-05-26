package jpabook.jpashop.controller;

import jakarta.validation.Valid;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberPageController {

    private final MemberService memberService;

    // 회원 등록 폼을 보여줌
    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    // 폼으로부터 데이터를 받아 저장
    @PostMapping("/members/new")
    public String create(@Valid @ModelAttribute("memberForm") MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Member member = new Member();
        member.setName(form.getName());


        memberService.join(member);

        return "redirect:/members";  // 등록 후 회원 목록으로 이동
    }

    @GetMapping("/members")
    public String list(Model model) {
        model.addAttribute("members", memberService.findMembers());
        return "members/memberList";
    }

    @PostMapping("/members/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        memberService.delete(id);
        return "redirect:/members";
    }
}
