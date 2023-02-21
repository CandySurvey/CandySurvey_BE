package com.CandySurvey_BE.repository;

import com.CandySurvey_BE.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByEmail(String email);

    Member findByNickname(String nickname);

//    @Query("SELECT distinct m FROM Member m join m.surveyList where m.nickname=:nickname")
//    Optional<Member> findMemberWithSurveyUsingJoin();
//
//    @Query("SELECT distinct m FROM Member m join m.answerList where m.nickname=:nickname")
//    Optional<Member> findMemberWithAnswerUsingJoin();


}
