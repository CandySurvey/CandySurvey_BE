package com.survey_backend.domain;

import com.survey_backend.domain.Enum.Role;
import com.survey_backend.dto.MemberSignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "members")
public class Member{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true, length=50)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member_survey", cascade =  CascadeType.ALL)
    private List<Survey> surveyList = new ArrayList<>();

    @OneToMany(mappedBy = "member_answer", cascade = CascadeType.ALL)
    private List<Answer> answerList = new ArrayList<>();



    public Member(MemberSignupRequestDto memberSignupRequestDto){
        email = memberSignupRequestDto.getEmail();
        password = memberSignupRequestDto.getPassword();
        nickname = memberSignupRequestDto.getNickname();
        role = Role.USER;
    }

    public void encryptPassword(PasswordEncoder passwordEncoder){
        password = passwordEncoder.encode(password);
    }
}
