package com.example.board.member;

import com.example.board.comment.CommentEntity;
import com.example.board.post.PostEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
public class MemberEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String email;

        private String password;

        @Column(nullable = false)
        private String nickname;

        private String provider;
        private String providerId;

        private LocalDateTime createdAt = LocalDateTime.now();

        @OneToMany(mappedBy = "member")
        private List<PostEntity> posts;

        @OneToMany(mappedBy = "member")
        private List<CommentEntity> comments;
    }


