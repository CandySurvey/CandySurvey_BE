package com.CandySurvey_BE.Controller;

import com.CandySurvey_BE.domain.*;
import com.CandySurvey_BE.domain.Enum.Required;
import com.CandySurvey_BE.domain.Enum.Type;
import com.CandySurvey_BE.service.*;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AnswerController {
    private final AnswerService answerService;
    private final MemberService memberService;

    @GetMapping("/answer/{code}")
    public String loadAnswer(@PathVariable String code){
        List<Answer> answerList = answerService.findAnswerBySurveyId(code);
        return "answerList";
    }

    @PostMapping("/answer/{code}")
    public void saveAnswer(HttpServletRequest request, @PathVariable String code) throws IOException {
        HttpSession session = request.getSession();

        Member submitter = memberService.findMember(session.getAttribute("email").toString(), session.getAttribute("email").toString());

        try{
            ServletInputStream inputStream = request.getInputStream();
            String json = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
            Answer saveAnswer = new Answer(json, code, submitter.getName(), submitter.getEmail());
            answerService.saveAnswer(saveAnswer);
        }catch(IllegalStateException e){

        }

    }

    @DeleteMapping("/answer/{code}")
    public void deleteAnswer(HttpServletRequest request, @PathVariable String code) throws IOException{
        HttpSession session = request.getSession();

        Member user = memberService.findMember(session.getAttribute("email").toString(), session.getAttribute("email").toString());

    }
}
