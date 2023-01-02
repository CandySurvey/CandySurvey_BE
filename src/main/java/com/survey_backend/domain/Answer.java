package com.survey_backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Table(name = "answers")
@Entity
public class Answer
{
}
