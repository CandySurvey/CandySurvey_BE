package com.survey_backend.repository;

import com.survey_backend.domain.Answer;
import com.survey_backend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query("SELECT distinct a FROM Answer a join a.member")
    List<Answer> findAllAnswerWithMemberUsingJoin();

    @Query("SELECT distinct a FROM Answer a join a.member where a.id=:id")
    Optional<Answer> findOneAnswerWithMemberUsingJoin();

}
