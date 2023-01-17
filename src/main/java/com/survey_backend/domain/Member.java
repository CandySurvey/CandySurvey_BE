package com.survey_backend.domain;

import com.survey_backend.domain.Enum.Role;
import com.survey_backend.dto.MemberSignupRequestDto;
import lombok.Builder;
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

//    @OneToMany(mappedBy = "member_survey", cascade =  CascadeType.ALL)
//    private List<Survey> surveyList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member_answer", cascade = CascadeType.ALL)
//    private List<Answer> answerList = new ArrayList<>();



    @Builder
    public Member(String email, String password, String nickname){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = Role.USER;
    }



    public Member(MemberSignupRequestDto request){
        email = request.getEmail();
        password = request.getPassword();
        nickname = request.getNickname();
        role = Role.USER;
    }

    public void encryptPassword(PasswordEncoder passwordEncoder){
        password = passwordEncoder.encode(password);
    }
}
