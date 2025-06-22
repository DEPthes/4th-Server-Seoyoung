package com.example.board.member.dto;

import com.example.board.member.MemberEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberResponse {
    private Long id;
    private String email;
    private String nickname;
    private LocalDateTime createdAt;

    public MemberResponse(MemberEntity member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.nickname = member.getNickname();
        this.createdAt = member.getCreatedAt();
    }
}
