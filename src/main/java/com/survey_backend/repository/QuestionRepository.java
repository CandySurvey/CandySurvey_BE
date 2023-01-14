package com.survey_backend.repository;


import com.survey_backend.domain.Question;
import com.survey_backend.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

//    @Query("SELECT distinct q FROM Question q join q.itemList where q.id=:id")
//    Optional<Question> findQuestionWithItemUsingJoin();

    List<Question> findQuestionBySection_id(Long section_id);
}
