package com.survey_backend.service;

import com.survey_backend.domain.Survey;
import com.survey_backend.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public Survey saveSurvey(Survey survey){
        return surveyRepository.save(survey);
    }

    public Optional<Survey> findSurveyWithAnswerAndSection(Survey survey){
        return surveyRepository.findSurveyWithSectionAndAnswerUsingJoin(survey.getId());
    }
}
