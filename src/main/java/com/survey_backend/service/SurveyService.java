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

    public List<Survey> findAllSurvey(){
        return surveyRepository.findAll();
    }

    public List<Survey> findByTitle(Survey survey, String status){
        return surveyRepository.findByTitleContainingAndStatus(survey.getTitle(), status);
    }

    public List<Survey> findSurveyPostByOwner(String nickname){
        return surveyRepository.findByOwner(nickname);
    }

    public Optional<Survey> findSurveyByHash(String hash){
        return checkSurveyExist(hash);
    }

    public void deleteSurveyById(Long owner_id, Long id){
        checkSurveyOwner(owner_id, id);
        surveyRepository.deleteById(id);
    }

    public void deleteSurveysByMember(Long member_id){
        surveyRepository.deleteSurveysByOwner(member_id);
    }

    public Optional<Survey> checkSurveyExist(String hash){
        Optional<Survey> findSurvey = surveyRepository.findBySurvey_hash(hash);
        if(findSurvey.isEmpty()){
            throw new IllegalStateException("설문이 존재하지 않습니다.");
        }
        return findSurvey;
    }

    public void checkSurveyOwner(Long member_id, Long id){
        Optional<Survey> findSurvey = surveyRepository.findById(id);
        if(findSurvey.get().getOwner()!=member_id){
            throw new IllegalStateException("권한이 없습니다.");
        }
    }
}
