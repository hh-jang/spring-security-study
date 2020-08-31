package com.hhjang.security.springsecuritystudy.config;

import com.hhjang.security.springsecuritystudy.config.handler.GoogleAuthenticationSuccessHandler;
import com.hhjang.security.springsecuritystudy.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final GoogleAuthenticationSuccessHandler successHandler;
    private final UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/test/**").permitAll()
                .antMatchers("/api/v1/**").hasRole("nameMatch")
                .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(userService);
    }
}
