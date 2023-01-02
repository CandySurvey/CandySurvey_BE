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
    private Long id;

    @Column(nullable = false)
    private String title;

    private String detail;

    private String survey_hash;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
    private List<Section> sectionList = new ArrayList<>();

    private String status;

    public Survey(String title, String detail, String survey_hash, Member member, String status){
        this.title = title;
        this.detail = detail;
        this.survey_hash = survey_hash;
        this.member = member;
        this.status = status;
    }


}
