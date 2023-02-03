package com.survey_backend.Controller;

import com.survey_backend.domain.Answer;
import com.survey_backend.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AnswerController {
    private final AnswerRepository answerRepository;

    @GetMapping("/answer/{code}")
    public String loadAnswer(@PathVariable String code){
        List<Answer> answerList = answerRepository.findAnswerBySurvey_hash(code);
        return "answerList";
    }

    @PostMapping("/answer/{code}/{nick}")
    public void saveAnswer(@PathVariable String code, @PathVariable String nick, @RequestParam("json") String answer){
//        answerRepository.save()
        //json 받아오는 code 추가하자
    }
}
