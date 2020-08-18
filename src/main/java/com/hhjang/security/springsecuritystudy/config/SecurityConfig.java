package com.hhjang.security.springsecuritystudy.config;

import com.hhjang.security.springsecuritystudy.config.handler.GoogleAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    final GoogleAuthenticationSuccessHandler successHandler;
//
//    public SecurityConfig(GoogleAuthenticationSuccessHandler successHandler) {
//        this.successHandler = successHandler;
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .mvcMatchers("/test").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .successHandler(successHandler)
//                .and()
//                .httpBasic();
//    }
}
