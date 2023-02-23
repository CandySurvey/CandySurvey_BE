package com.CandySurvey_BE.domain;

import com.CandySurvey_BE.domain.Enum.Role;
import com.CandySurvey_BE.dto.MemberSignupRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

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
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

//    @OneToMany(mappedBy = "member_survey", cascade =  CascadeType.ALL)
//    private List<Survey> surveyList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member_answer", cascade = CascadeType.ALL)
//    private List<Answer> answerList = new ArrayList<>();



    @Builder
    public Member(String email, String password, String name, Role role){
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public Member update(String name){
        this.name = name;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

    public void encryptPassword(PasswordEncoder passwordEncoder){
        password = passwordEncoder.encode(password);
    }
}
