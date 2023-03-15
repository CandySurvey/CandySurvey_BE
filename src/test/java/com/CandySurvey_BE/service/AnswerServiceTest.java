package com.CandySurvey_BE.service;

import com.CandySurvey_BE.domain.Answer;
import com.CandySurvey_BE.domain.Member;
import com.CandySurvey_BE.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
//@TestPropertySource(properties = {"spring.config.location=classpath:application-test.properties"})
class AnswerServiceTest {
    @Autowired
    private AnswerService answerService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(String name, String email, String provider){
        Member member = new Member(name, email, provider);

        return memberRepository.save(member);
    }

    public Answer createAnswer(String response, String hash, Member member){
        Answer answer = new Answer(response, hash, member);

        return answerService.saveAnswer(answer);
    }

    @Test
    @DisplayName("응답에 따른 유저 정보 확인")
    public void answerMemberInfo(){
        Member member = createMember("Kang", "test@gmail.com", "google");
        Answer answer = createAnswer("test answer", "1q2w3e4r", member);

        List<Answer> findAnswer = answerService.findAnswerBySurveyId("1q2w3e4r");

        System.out.println(findAnswer.get(0).getMember().getEmail());

    }

}