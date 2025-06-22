package com.example.board.security;

import com.example.board.member.MemberEntity;
import com.example.board.member.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@Transactional
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;

    public CustomOAuth2UserService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //사용자 정보 요청
    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(request);

        String provider = request.getClientRegistration().getRegistrationId(); // ex) "kakao"
        Map<String, Object> attributes = oAuth2User.getAttributes();

        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");

        String providerId = String.valueOf(attributes.get("id"));
        String email = kakaoAccount.get("email") != null ? kakaoAccount.get("email").toString() : null;
        String nickname = profile.get("nickname").toString();

        MemberEntity member = memberRepository
                .findByProviderAndProviderId(provider, providerId)
                .orElseGet(() -> {
                    MemberEntity newMember = new MemberEntity();
                    newMember.setEmail(email);
                    newMember.setNickname(nickname);
                    newMember.setProvider(provider);
                    newMember.setProviderId(providerId);
                    return memberRepository.save(newMember);
                });

        return new CustomOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                attributes,
                "id",
                nickname
        );
    }
}