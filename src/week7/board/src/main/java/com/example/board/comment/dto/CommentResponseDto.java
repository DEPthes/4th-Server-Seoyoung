package com.example.board.comment.dto;

import com.example.board.comment.CommentEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
    private String content;
    private String authorNickname;
    private LocalDateTime createdAt;
    @JsonProperty("isMine")
    private boolean isMine;

    public CommentResponseDto(CommentEntity comment, boolean isMine) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.authorNickname = comment.getMember().getNickname();
        this.createdAt = comment.getCreatedAt();
        this.isMine = isMine;
    }
}
