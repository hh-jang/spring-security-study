package com.hhjang.security.springsecuritystudy.config.auth.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public enum OAuthPlatform {
    GOOGLE("google"),
    NAVER("naver"),
    KAKAO("kakao"),
    UNKNOWN("unknown");

    private final String registrationId;

    public static OAuthPlatform getOAuthPlatformByRegistrationId(String registrationId) {
        return Stream.of(values())
                .filter(oAuthPlatform -> oAuthPlatform.registrationId.equals(registrationId))
                .findAny()
                .orElse(UNKNOWN);
    }
}
