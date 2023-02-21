package com.CandySurvey_BE.service;

import com.CandySurvey_BE.domain.Member;
import com.CandySurvey_BE.dto.JwtRequestDto;
import com.CandySurvey_BE.dto.MemberSignupRequestDto;
import com.CandySurvey_BE.repository.MemberRepository;
import com.CandySurvey_BE.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public String signup(MemberSignupRequestDto request){
        Member existMember = memberRepository.findByEmail(request.getEmail());

        if(existMember!=null) return "중복된 이메일입니다.";

        Member member = new Member(request);
        member.encryptPassword(passwordEncoder);

        memberRepository.save(member);
        return member.getEmail();
    }

    public String login(JwtRequestDto request) throws Exception{
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        return principal.getUsername();
    }
}
