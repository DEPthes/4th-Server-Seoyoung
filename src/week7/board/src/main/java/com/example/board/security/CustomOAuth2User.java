
package com.example.board.security;

import com.example.board.member.MemberEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collection;
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