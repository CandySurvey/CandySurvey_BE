//package com.survey_backend.repository;
//
//import com.survey_backend.domain.Section;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface SectionRepository extends JpaRepository<Section, Long> {
//
////    @Query("SELECT distinct s FROM Section s join s.questionList where s.id=:id")
////    Optional<Section> findSectionWithQuestionUsingJoin();
//
//    List<Section> findSectionBySurvey_id(Long survey_id);
//
//    void deleteSectionsBySurvey_id(Long survey_id);
//}
