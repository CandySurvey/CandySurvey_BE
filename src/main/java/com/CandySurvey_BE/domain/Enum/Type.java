package com.CandySurvey_BE.domain.Enum;

public enum Type {
    CHECKBOX("checkbox"), OPTIONAL("optional"), DROPBOX("dropbox"),
    SHORT_ANS("short_ans"), LONG_ANS("long_ans"), PHONE_NUM("phone_num"),
    EMAIL("email"), IMG("img"), VIDEO("video"), FILE("file"), DATE("date"), STAR("star"),
    LINEAR("linear"), DROPDOWN("dropdown");

    private String type;

    Type(String type){
        this.type = type;
    }
}
