package com.CandySurvey_BE.Controller;

import com.CandySurvey_BE.dto.JwtRequestDto;
import com.CandySurvey_BE.dto.MemberSignupRequestDto;
//import com.CandySurvey_BE.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/oauth")
@AllArgsConstructor
public class OAuthController {

    @GetMapping("/loginInfo")
    public String oauthLoginInfo(Authentication authentication){
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        Map<String, Object> attributes = oAuth2User.getAttributes();

        return attributes.toString();
    }

//    private final AuthService authService;

//    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String login(@RequestBody JwtRequestDto request){
//        try{
//            return authService.login(request);
//        }catch(Exception e){
//            return e.getMessage();
//        }
//    }
//
//    @PostMapping(value = "signup", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String signup(@RequestBody MemberSignupRequestDto request){
//        return authService.signup(request);
//    }
}
