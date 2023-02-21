package com.CandySurvey_BE.Controller;

import com.CandySurvey_BE.dto.JwtRequestDto;
import com.CandySurvey_BE.dto.MemberSignupRequestDto;
import com.CandySurvey_BE.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody JwtRequestDto request){
        try{
            return authService.login(request);
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @PostMapping(value = "signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestBody MemberSignupRequestDto request){
        return authService.signup(request);
    }
}
