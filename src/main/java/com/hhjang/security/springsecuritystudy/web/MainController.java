package com.hhjang.security.springsecuritystudy.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@Slf4j
public class MainController {
    private HttpSession httpSession;

    public MainController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @GetMapping(value = "/session")
    public void getSession() {
        httpSession.getAttributeNames()
            .asIterator()
                .forEachRemaining(s -> log.info("value : {}", s));
    }

    @GetMapping(value = "/test/test")
    public String getTest() {
        return "test/test";
    }
}
