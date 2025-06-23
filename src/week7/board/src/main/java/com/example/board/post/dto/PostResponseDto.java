package com.example.board.post.dto;

import com.example.board.post.PostEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String authorNickname;
    private LocalDateTime createdAt;
    private boolean isMine; // 내가 쓴 글인지 여부

    public PostResponseDto(PostEntity post, boolean isMine) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.authorNickname = post.getMember().getNickname();
        this.createdAt = post.getCreatedAt();
        this.isMine = isMine;
    }
}
