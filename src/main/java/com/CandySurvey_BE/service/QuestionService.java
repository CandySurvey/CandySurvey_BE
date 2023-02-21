package com.CandySurvey_BE.service;

import com.CandySurvey_BE.domain.Question;
import com.CandySurvey_BE.repository.QuestionRepository;
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

    public List<Question> findQuestionBySurveyHash(String survey_hash){
        return questionRepository.findQuestionBySurvey_hash(survey_hash);
    }

    public void deleteQuestionsBySurveyId(String survey_hash){
        questionRepository.deleteQuestionsBySurvey_hash(survey_hash);
    }
}
