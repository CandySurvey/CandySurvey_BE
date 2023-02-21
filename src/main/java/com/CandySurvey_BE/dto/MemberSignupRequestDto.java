package com.CandySurvey_BE.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@Getter
@Setter
public class MemberSignupRequestDto {

    @NotBlank(message = "Please enter your Email!")
    private String email;

    @NotBlank(message = "Please enter your password!")
    @Length(min = 8, max = 16, message = "Please enter password in 8 to 16 characters!")
    private String password;

    @NotBlank(message = "Please enter your Nickname!")
    private String nickname;

    @Builder
    public MemberSignupRequestDto(String email, String password, String nickname){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}