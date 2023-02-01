package com.survey_backend.Controller;

import com.survey_backend.repository.ItemRepository;
import com.survey_backend.repository.QuestionRepository;
import com.survey_backend.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class SurveyController {
    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;
    private final ItemRepository itemRepository;

    @PostMapping("/create_survey")
    public void saveSurvey(HttpServletRequest request) throws IOException {

    }

    @GetMapping("/survey/{code}")
    public String loadSurvey(@RequestParam String code){
        return "";
    }

}

