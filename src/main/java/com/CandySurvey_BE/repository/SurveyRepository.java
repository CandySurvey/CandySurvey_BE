package com.CandySurvey_BE.repository;

import com.CandySurvey_BE.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

//    List<Survey> findByTitleContaining(String title);

    List<Survey> findByTitleContainingAndStatus(String title, String status);

    Optional<Survey> findBySurvey_hash(String survey_hash);

    List<Survey> findByOwner(String owner);

    void deleteSurveysByOwner(Long member_id);



//    @Query("SELECT distinct s FROM Survey s join s.sectionList, s.answerList where s.id=:id")
//    Optional<Survey> findSurveyWithSectionAndAnswerUsingJoin(Long id);

//    @Query("SELECT distinct s FROM Survey s join s.answerList where s.id=:id")
//    Optional<Survey> findMemberWithAnswerUsingJoin(Long id);








}
