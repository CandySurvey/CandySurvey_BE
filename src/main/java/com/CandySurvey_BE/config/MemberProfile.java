package com.CandySurvey_BE.config;

import com.CandySurvey_BE.domain.Enum.Role;
import com.CandySurvey_BE.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberProfile {
    private String name;
    private String email;
    private String provider;
//    private String picture;
//    private Role role;

    public Member toMember(){
        return Member.builder()
                .name(name)
                .email(email)
                .provider(provider)
//                .picture(picture)
//                .role(role)
                .build();
    }
}
