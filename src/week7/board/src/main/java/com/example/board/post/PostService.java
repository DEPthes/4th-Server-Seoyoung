package com.example.board.post;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    // 게시글 이메일로 조회
    public List<PostEntity> getPostsByMemberEmail(String email) {
        return postRepository.findByMemberEmail(email);
    }

    // 게시글 저장
    public PostEntity savePost(PostEntity post) {
        return postRepository.save(post);
    }

    // 게시글 삭제
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    // 게시글 수정
    @Transactional
    public void updatePost(Long id, PostEntity updatedPost) {
        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));

        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
    }

    public PostEntity getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 게시글이 존재하지 않습니다."));
    }


}
