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

    private String nick;

    private String email;

    private String hash;

//    @ManyToOne
//    @JoinColumn(name = "survey_id")
//    private Survey survey;
//
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

    public Answer(String answer, String hash, String nick, String email){
        this.answer = answer;
        this.hash = hash;
        this.nick = nick;
        this.email = email;
    }
}
