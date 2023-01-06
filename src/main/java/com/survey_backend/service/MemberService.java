package com.survey_backend.service;

import com.survey_backend.domain.Member;
import com.survey_backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);

        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByEmail(member.getEmail()).get();
        if(findMember!=null){
            throw new IllegalStateException("이미 가입된 이메일입니다.");
        }
    }

    public Member findByEmail(String email){
        return memberRepository.findByEmail(email).get();
    }
}
