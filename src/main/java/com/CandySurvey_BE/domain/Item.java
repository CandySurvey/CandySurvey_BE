package com.CandySurvey_BE.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "items")
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    private String line;

    private Long question_id;

//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    private Question question;

    public Item(String line, Long question_id){
        this.line = line;
        this.question_id = question_id;
    }

}
