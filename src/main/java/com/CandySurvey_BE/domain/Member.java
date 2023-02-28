package com.CandySurvey_BE.domain;

import com.CandySurvey_BE.domain.Enum.Role;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@DynamicUpdate
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "provider", nullable = false)
    private String provider;

//    @Column(name = "picture")
//    private String picture;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "role")
//    private Role role;

    @Builder
    public Member(String name, String email, String provider){
        this.name = name;
        this.email = email;
        this.provider = provider;
//        this.picture = picture;
//        this.role = role;
    }

    public Member update(String name, String email){
        this.name = name;
        this.email = email;

        return this;
    }
}



//package com.CandySurvey_BE.domain;
//
//import com.CandySurvey_BE.domain.Enum.Role;
//import com.CandySurvey_BE.dto.MemberSignupRequestDto;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.persistence.*;
//
//@NoArgsConstructor
//@Getter
//@Entity
//@Table(name = "members")
//public class Member{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "member_id")
//    private Long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false, unique = true, length=50)
//    private String email;
//
////    @Column(nullable = false)
////    private String password;
//
//    @Enumerated(EnumType.STRING)
//    private Role role;
//
////    @OneToMany(mappedBy = "member_survey", cascade =  CascadeType.ALL)
////    private List<Survey> surveyList = new ArrayList<>();
////
////    @OneToMany(mappedBy = "member_answer", cascade = CascadeType.ALL)
////    private List<Answer> answerList = new ArrayList<>();
//
//
//
//    @Builder
//    public Member(String email, String password, String name, Role role){
//        this.email = email;
//        this.password = password;
//        this.name = name;
//        this.role = role;
//    }
//
//    public Member update(String name){
//        this.name = name;
//        return this;
//    }
//
//    public String getRoleKey(){
//        return this.role.getKey();
//    }
//
//    public void encryptPassword(PasswordEncoder passwordEncoder){
//        password = passwordEncoder.encode(password);
//    }
//}
