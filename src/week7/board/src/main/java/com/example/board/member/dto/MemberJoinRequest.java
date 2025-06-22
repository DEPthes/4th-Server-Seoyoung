package com.example.board.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberJoinRequest {
    private String email;
    private String password;
    private String nickname;
}
