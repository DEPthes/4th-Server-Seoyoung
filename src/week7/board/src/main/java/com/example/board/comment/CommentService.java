package com.example.board.comment;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // 댓글 저장
    public CommentEntity saveComment(CommentEntity comment) {
        return commentRepository.save(comment);
    }

    // 댓글 전체 조회
    public List<CommentEntity> getAllComments() {
        return commentRepository.findAll();
    }

    // 특정 게시글의 댓글 조회
    public List<CommentEntity> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    // 댓글 삭제
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    // 댓글 단건 조회
    public Optional<CommentEntity> getCommentById(Long id) {
        return commentRepository.findById(id);
    }
}
