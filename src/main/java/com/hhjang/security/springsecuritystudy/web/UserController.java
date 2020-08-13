package com.hhjang.security.springsecuritystudy.web;

import com.hhjang.security.springsecuritystudy.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/user")
    public void confirmUser(@AuthenticationPrincipal OAuth2User user) {
        Map<String, Object> attributes = user.getAttributes();

        attributes.keySet()
                .forEach(key -> log.info("key : " + key + "\t value : " + attributes.get(key)));
    }
}
