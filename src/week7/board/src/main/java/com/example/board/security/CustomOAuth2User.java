
package com.example.board.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collection;
import java.util.Map;

public class CustomOAuth2User extends DefaultOAuth2User {

    private final String nickname;
    private final String email;

    public CustomOAuth2User(Collection<? extends GrantedAuthority> authorities,
                            Map<String, Object> attributes,
                            String nameAttributeKey,
                            String nickname,
                            String email) {
        super(authorities, attributes, nameAttributeKey);
        this.nickname = nickname;
        this.email = email;

    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() { // ]
        return email;
    }
}