package com.survey_backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Table(name = "sections")
@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String detail;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<Question> question = new ArrayList<>();

    public Section(String title, String detail, Survey survey){
        this.title = title;
        this.detail = detail;
        this.survey = survey;
    }
}
