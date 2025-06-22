package com.example.board.member;

import com.example.board.member.dto.MemberJoinRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder; // 비밀번호 암호화를 위한 객체

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public MemberEntity register(MemberJoinRequest request) {
        MemberEntity member = new MemberEntity();
        member.setEmail(request.getEmail());
        member.setPassword(passwordEncoder.encode(request.getPassword()));  // 비밀번호 암호화
        member.setNickname(request.getNickname());
        return memberRepository.save(member);
    }

    public MemberEntity getById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("회원 없음"));
    }
}
