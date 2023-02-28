package com.CandySurvey_BE.service;

import com.CandySurvey_BE.domain.Member;
import com.CandySurvey_BE.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
//        validateDuplicateMember(member);

        return memberRepository.save(member);
    }

//    private void validateDuplicateMember(Member member){
//        Optional<Member> findMember = memberRepository.findByEmail(member.getEmail());
//        if(findMember!=null){
//            throw new IllegalStateException("이미 가입된 이메일입니다.");
//        }
//    }
//
//    public Member findByEmail(String email){
//        return memberRepository.findByEmail(email).get();
//    }
}
