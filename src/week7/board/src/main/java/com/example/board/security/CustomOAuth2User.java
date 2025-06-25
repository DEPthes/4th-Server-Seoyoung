
package com.example.board.security;

import com.example.board.member.MemberEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomOAuth2User extends DefaultOAuth2User {

    private final String nickname;
    private final String email;
    private final MemberEntity member;

    public CustomOAuth2User(Collection<? extends GrantedAuthority> authorities,
                            Map<String, Object> attributes,
                            String nameAttributeKey,
                            String nickname,
                            String email,
                            MemberEntity member) {
        super(authorities, attributes, nameAttributeKey);
        this.nickname = nickname;
        this.email = email;
        this.member = member;

    }

    // nickname 등을 attributes 에 추가해주는 유틸 메서드
    private static Map<String, Object> extendAttributes(Map<String, Object> originalAttributes,
                                                        String nickname,
                                                        String email,
                                                        MemberEntity member) {
        Map<String, Object> extended = new HashMap<>(originalAttributes);
        extended.put("nickname", nickname);
        extended.put("email", email);
        extended.put("member", member); // 필요 시 Thymeleaf에서 사용 가능
        return extended;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() { // ]
        return email;
    }

    public MemberEntity getMember() {
        return member;
    }
}