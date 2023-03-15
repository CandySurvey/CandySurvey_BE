package com.CandySurvey_BE.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Table(name = "answers")
@Entity
public class Answer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private Long id;

    private String answer;

//    private String nick;
//
//    private String email;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "memberInfo")
    private Member member;

    private String hash;

//    @ManyToOne
//    @JoinColumn(name = "survey_id")
//    private Survey survey;
//
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

    @Builder
    public Answer(String answer, String hash, Member member){
        this.answer = answer;
        this.hash = hash;
        this.member = member;
    }
}
