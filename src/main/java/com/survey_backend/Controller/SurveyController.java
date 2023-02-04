package com.survey_backend.Controller;

import com.survey_backend.service.ItemService;
import com.survey_backend.service.QuestionService;
import com.survey_backend.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class SurveyController {
    private final SurveyService surveyService;
    private final QuestionService questionService;
    private final ItemService itemService;

    @PostMapping("/create_survey")
    public void saveSurvey(HttpServletRequest request) throws IOException {

    }

    @GetMapping("/survey/{code}")
    public String loadSurvey(@RequestParam String code){
        return "";
    }

}

