package com.survey_backend.Controller;

import com.survey_backend.domain.Answer;
import com.survey_backend.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AnswerController {
    private final AnswerRepository answerRepository;

    @GetMapping("/answer/{code}")
    public String loadAnswer(@RequestParam String code){
        List<Answer> answerList = answerRepository.findAnswerBySurvey_hash(code);
        return "answerList";
    }
}
