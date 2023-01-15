package com.survey_backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Table(name = "surveys")
@Entity
public class Survey{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "survey_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    private String detail;

    private String survey_hash;

    private String owner;

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

    private String status;
//
//    @OneToMany(mappedBy = "survey_section", cascade = CascadeType.ALL)
//    private List<Section> sectionList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "survey_answer", cascade = CascadeType.ALL)
//    private List<Section> answerList = new ArrayList<>();




    public Survey(String title, String detail, String survey_hash, String owner, String status){
        this.title = title;
        this.detail = detail;
        this.survey_hash = survey_hash;
        this.owner = owner;
        this.status = status;
    }


}
