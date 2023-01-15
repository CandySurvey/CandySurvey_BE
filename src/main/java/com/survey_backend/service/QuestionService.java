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

    public Question saveSection(Question question){
        return questionRepository.save(question);
    }

    public List<Question> findQuestionBySectionId(Long section_id){
        return questionRepository.findQuestionBySection_id(section_id);
    }

    public void deleteQuestionsBySectionId(Long section_id){
        questionRepository.deleteQuestionsBySection_id(section_id);
    }
}
