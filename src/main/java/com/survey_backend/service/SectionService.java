package com.survey_backend.service;

import com.survey_backend.domain.Section;
import com.survey_backend.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SectionService {
    final SectionRepository sectionRepository;

    public Section saveSection(Section section){
        return sectionRepository.save(section);
    }

    public List<Section> findSectionBySurveyId(Long survey_id){
        return sectionRepository.findSectionBySurvey_id(survey_id);
    }

    public void deleteSectionsBySurveyId(Long survey_id){
        sectionRepository.deleteSectionsBySurvey_id(survey_id);
    }
}
