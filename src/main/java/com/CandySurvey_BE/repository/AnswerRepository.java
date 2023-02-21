package com.CandySurvey_BE.repository;

import com.CandySurvey_BE.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

//    @Query("SELECT distinct a FROM Answer a join a.member")
//    List<Answer> findAllAnswerWithMemberUsingJoin();
//
//    @Query("SELECT distinct a FROM Answer a join a.member where a.id=:id")
//    Optional<Answer> findOneAnswerWithMemberUsingJoin();

    List<Answer> findAnswerBySurvey_hash(String survey_hash);

    List<Answer> findAnswerByMember_nick(String member_nick);

    void deleteAnswersByMember_nick(String nickname);

    void deleteAnswersBySurvey_id(Long survey_id);

}
