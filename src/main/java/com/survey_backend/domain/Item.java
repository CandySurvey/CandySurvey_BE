package com.survey_backend.domain;

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
    private Long id;

    private String line;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Item(String line, Question question){
        this.line = line;
        this.question = question;
    }

}
