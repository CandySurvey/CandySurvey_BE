package com.CandySurvey_BE.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private String hash;

    private String status;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "memberInfo")
    private Member member;
//
//    @OneToMany(mappedBy = "survey_section", cascade = CascadeType.ALL)
//    private List<Section> sectionList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "survey_answer", cascade = CascadeType.ALL)
//    private List<Section> answerList = new ArrayList<>();




    public Survey(String title, String detail, String hash, Member member, String status){
        this.title = title;
        this.detail = detail;
        this.hash = hash;
        this.member = member;
        this.status = status;
    }


}
