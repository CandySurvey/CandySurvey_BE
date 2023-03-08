package com.CandySurvey_BE.Controller;

import com.CandySurvey_BE.config.OAuthService;
//import com.CandySurvey_BE.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/oauth")

public class OAuthController {

    @GetMapping("/loginInfo")
    public String oauthLoginInfo(Authentication authentication, HttpServletResponse response, HttpServletRequest request) {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        Map<String, Object> attributes = oAuth2User.getAttributes();

        System.out.println("test : "+attributes.toString());

        HttpSession session = request.getSession();

        session.setAttribute("email", attributes.get("email").toString());
        session.setAttribute("name", attributes.get("name").toString());
        session.setAttribute("provider", attributes.get("provider").toString());

        return attributes.toString();
    }

    @GetMapping("/sessionInfo")
    public String sessionInfo(HttpServletRequest request){
        HttpSession session = request.getSession();

        return session.getAttribute("provider").toString();
    }

//    public String oauthLoginInfo(Authentication authentication){
//
//        System.out.println("test : "+authentication);
//        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
//
//        Map<String, Object> attributes = oAuth2User.getAttributes();
////        System.out.println("attributes : " + attributes);
//
//        return attributes.toString();
//    }

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
