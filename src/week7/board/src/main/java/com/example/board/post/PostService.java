package com.example.board.post;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 게시글 전체 조회
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    // 게시글 단건 조회
    public Optional<PostEntity> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // 게시글 저장
    public PostEntity savePost(PostEntity post) {
        return postRepository.save(post);
    }

    // 게시글 삭제
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
