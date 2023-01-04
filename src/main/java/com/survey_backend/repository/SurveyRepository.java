package com.survey_backend.repository;

import com.survey_backend.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    Optional<Survey> findById(Long id);

    @Query("SELECT distinct s FROM Survey s join s.sectionList where s.id=:id")
    Optional<Survey> findSurveyWithSectionUsingJoin();

    @Query("SELECT distinct s FROM Survey s join s.answerList where s.id=:id")
    Optional<Survey> findMemberWithAnswerUsingJoin();

    List<Survey> findByTitleContaining(String title);


}
