package com.survey_backend.service;

import com.survey_backend.domain.Question;
import com.survey_backend.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {
    final QuestionRepository questionRepository;

    public Question saveQuestion(Question question){
        return questionRepository.save(question);
    }

    public List<Question> findQuestionBySurveyId(Long survey_id){
        return questionRepository.findQuestionBySurvey_id(survey_id);
    }

    public void deleteQuestionsBySurveyId(Long survey_id){
        questionRepository.deleteQuestionsBySurvey_id(survey_id);
    }
}
