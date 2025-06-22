package com.example.board.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    // 특정 게시글의 댓글 목록 조회
    List<CommentEntity> findByPostId(Long postId);
}
