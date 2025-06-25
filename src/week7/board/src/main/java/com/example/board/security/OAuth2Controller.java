package com.example.board.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuth2Controller {

    @GetMapping("/oauth2/callback/kakao")
    public String redirectToSpringSecurity(HttpServletRequest request) {
        // Spring Security가 자동 처리하는 기본 경로로 리다이렉트
        return "redirect:/login/oauth2/code/kakao";
    }
}
