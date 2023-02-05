package com.survey_backend.domain;

import com.survey_backend.domain.Enum.Required;
import com.survey_backend.domain.Enum.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Table(name = "questions")
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private Long id;

    private String title;

    private String detail;

    private Required required;

    private Type type;

    @Nullable
    private String reg_express;

    private String survey_hash;

//    @ManyToOne
//    @JoinColumn(name = "section_id")
//    private Section section;
//
//    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
//    private List<Item> itemList = new ArrayList<>();

    public Question(String title, String detail, Required required,
                    Type type, String reg_express, String survey_hash){
        this.title = title;
        this.detail = detail;
        this.required = required;
        this.type = type;
        this.reg_express = reg_express;
        this.survey_hash = survey_hash;
    }

}
