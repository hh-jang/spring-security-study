package com.hhjang.security.springsecuritystudy.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hhjang.security.springsecuritystudy.domain.user.google.GoogleUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Component
@Slf4j
public class GoogleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private HttpSession httpSession;
    private ObjectMapper objectMapper;

    public GoogleAuthenticationSuccessHandler(HttpSession httpSession, ObjectMapper objectMapper) {
        this.httpSession = httpSession;
        this.objectMapper = objectMapper;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        GoogleUser googleUser = objectMapper.convertValue(authentication.getDetails(), GoogleUser.class);

        httpSession.setAttribute("hahahaha", "hohohoho");
    }
}
