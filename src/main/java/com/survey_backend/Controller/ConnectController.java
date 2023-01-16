package com.survey_backend.Controller;

import com.survey_backend.domain.Member;
import com.survey_backend.dto.MemberSignupRequestDto;
import com.survey_backend.repository.MemberRepository;
import com.survey_backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
public class ConnectController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("signup")
    public String signup(HttpServletRequest request, HttpServletResponse response){
        String MemberEmail = request.getParameter("email");
        String MemberPW = request.getParameter("pw");
        String MemberNickname = request.getParameter("nickname");

        try{
            MemberSignupRequestDto dto = MemberSignupRequestDto.builder()
                    .email(MemberEmail)
                    .password(MemberPW)
                    .nickname(MemberNickname)
                    .build();

            Member member = Member.createMember(dto);
            Member savedMember = memberService.saveMember(member);

            return "join success!";


        }catch(IllegalStateException e){
            return "error";
        }

    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        try{
            String MemberEmail = request.getParameter("email");
            String MemberPW = request.getParameter("pw");

            Member member = memberService.findByEmail(MemberEmail);

            if(member!=null&&member.getPassword().equals(MemberPW)){
                return member.getNickname();
            }
            else{
                System.out.println("등록되어 있지 않은 회원입니다.");
                return "no member";
            }
        }catch(IllegalStateException e){
            return "error";
        }
    }
}
