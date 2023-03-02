package com.CandySurvey_BE.repository;


import com.CandySurvey_BE.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

//    @Query("SELECT distinct q FROM Question q join q.itemList where q.id=:id")
//    Optional<Question> findQuestionWithItemUsingJoin();

    List<Question> findQuestionByHash(String hash);

    void deleteQuestionsByHash(String hash);
}
