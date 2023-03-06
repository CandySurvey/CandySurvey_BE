package com.CandySurvey_BE.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private static final String[] AUTH_WHITELIST = {
//            "/v2/api-docs",
//            "/v3/api-docs/**",
//            "/configuration/ui",
//            "/swagger-resources/**",
//            "/configuration/security",
//            "/swagger-ui.html",
//            "/webjars/**",
//            "/file/**",
//            "/image/**",
//            "/swagger/**",
//            "/swagger-ui/**",
//            "/h2/**"
//    };
//
//    @Override
//    public void configure(WebSecurity web) throws Exception{
//        web.ignoring().antMatchers(AUTH_WHITELIST);
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/auth/**").permitAll()
//                .anyRequest().authenticated();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder encodePassword(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception{
//        return super.authenticationManagerBean();
//    }
//
//}

import com.CandySurvey_BE.domain.Enum.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    2023.03.06 주석처리
//    private final OAuthService oAuthService;
//
//    //encoder
//    @Bean
//    public BCryptPasswordEncoder encoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception{
//        web.ignoring().mvcMatchers("/members/**", "/image/**");
//        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//
//        http
//                .csrf().disable()
//                .headers().frameOptions().disable()
//                .and()
//                .logout().logoutSuccessUrl("/")
//                .and()
//                .oauth2Login()
//                .defaultSuccessUrl("/oauth2/loginInfo", true)
//                .userInfoEndpoint()
//                .userService(oAuthService);
//    }


// 2023.03.06 임시 추가

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService);

    }


//    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
//        this.customOAuth2UserService = customOAuth2UserService;
//    }

//    2023.02.23
//    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService){
//        this.customOAuth2UserService = customOAuth2UserService;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
//        http
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .formLogin().disable()
//                .httpBasic().disable()
//                .authorizeRequests()
//                .antMatchers("/api/user").permitAll()
//                .and()
//                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
//        return http.build();
//    }
//    2023.02.23
}
