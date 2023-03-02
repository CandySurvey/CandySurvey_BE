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

    public List<Question> findQuestionBySurveyHash(String hash){
        return questionRepository.findQuestionByHash(hash);
    }

    public void deleteQuestionsBySurveyId(String hash){
        questionRepository.deleteQuestionsByHash(hash);
    }
}
