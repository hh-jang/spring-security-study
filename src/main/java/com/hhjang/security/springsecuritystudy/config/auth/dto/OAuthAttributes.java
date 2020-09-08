package com.hhjang.security.springsecuritystudy.config.auth.dto;

import com.hhjang.security.springsecuritystudy.config.auth.domain.OAuthPlatform;
import com.hhjang.security.springsecuritystudy.domain.user.Role;
import com.hhjang.security.springsecuritystudy.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Getter
public class OAuthAttributes {
    private String attributeKey;
    private Map<String, Object> attribute;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(String attributeKey, Map<String, Object> attribute,
                           String name, String email, String picture) {
        this.attributeKey = attributeKey;
        this.attribute = attribute;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId, String attributeKey, Map<String, Object> attribute) {
        OAuthPlatform oAuthPlatform = OAuthPlatform.getOAuthPlatformByRegistrationId(registrationId);

        switch (oAuthPlatform) {
            case GOOGLE: return ofGoogle(attributeKey, attribute);
            case NAVER: return ofNaver(attributeKey, attribute);
            default: throw new RuntimeException("not surpported operation");
        }
    }

    private static OAuthAttributes ofNaver(String attributeKey, Map<String, Object> attribute) {
        return OAuthAttributes.builder()
                .name((String) attribute.get("name"))
                .email((String) attribute.get("email"))
                .picture((String) attribute.get("picture"))
                .attribute(attribute)
                .attributeKey(attributeKey)
                .build();
    }

    private static OAuthAttributes ofGoogle(String attributeKey, Map<String, Object> attribute) {
        return OAuthAttributes.builder()
                .name((String) attribute.get("name"))
                .email((String) attribute.get("email"))
                .picture((String) attribute.get("picture"))
                .attribute(attribute)
                .attributeKey(attributeKey)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .name(name)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
