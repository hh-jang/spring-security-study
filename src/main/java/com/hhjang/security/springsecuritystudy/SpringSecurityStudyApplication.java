package com.hhjang.security.springsecuritystudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringSecurityStudyApplication {

    private static final String KEY_PROPERTIES = "spring.config.location=classpath:/key.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringSecurityStudyApplication.class)
                .properties(KEY_PROPERTIES)
                .run(args);
    }

}
