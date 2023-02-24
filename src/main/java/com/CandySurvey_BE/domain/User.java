package com.CandySurvey_BE.domain;

import com.CandySurvey_BE.domain.Enum.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
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

    @Column(name = "picture")
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public User(String name, String email, String provider, String picture){
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.picture = picture;
    }

    public User update(String picture){
        this.picture = picture;

        return this;
    }
}
