package com.example.board.security;

import com.example.board.member.MemberEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final MemberEntity member;

    public CustomUserDetails(MemberEntity member) {
        this.member = member;
    }

    public MemberEntity getMember() {
        return member;
    }

    public String getNickname() {
        return member.getNickname();
    }
    public String getName() {
        return member.getNickname(); // 또는 getEmail()
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getEmail(); // 로그인 기준: 이메일
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
