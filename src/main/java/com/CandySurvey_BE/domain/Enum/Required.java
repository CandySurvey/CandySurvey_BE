package com.CandySurvey_BE.domain.Enum;

public enum Required {
    NECESSARY("necessary"), UNNECESSARY("unnecessary");

    private String required;

    Required(String required){
        this.required = required;
    }
}
