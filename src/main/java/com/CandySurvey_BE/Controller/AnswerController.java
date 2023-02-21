package com.CandySurvey_BE.Controller;

import com.CandySurvey_BE.domain.Answer;
import com.CandySurvey_BE.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AnswerController {
    private final AnswerService answerService;

    @GetMapping("/answer/{code}")
    public String loadAnswer(@PathVariable String code){
        List<Answer> answerList = answerService.findAnswerBySurveyId(code);
        return "answerList";
    }

    @PostMapping("/answer/{code}/{nick}")
    public void saveAnswer(@PathVariable String code, @PathVariable String nick, HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String json = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);


//        answerRepository.save()
//        json 받아오는 code 추가하자
    }
}
