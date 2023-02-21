package com.CandySurvey_BE.domain;

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

    private String member_nick;

    private String survey_hash;

//    @ManyToOne
//    @JoinColumn(name = "survey_id")
//    private Survey survey;
//
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

    public Answer(String answer, String survey_hash, String member_nick){
        this.answer = answer;
        this.survey_hash = survey_hash;
        this.member_nick = member_nick;
    }
}
