package com.hhjang.security.springsecuritystudy;

import com.hhjang.security.springsecuritystudy.domain.user.Role;
import com.hhjang.security.springsecuritystudy.domain.user.User;
import com.hhjang.security.springsecuritystudy.domain.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("local")
public class UserRepositoryTest {
    @Autowired
    protected UserRepository repository;

    @Test
    public void create() {
        // Given
        User user = new User().builder()
                .name("테스터")
                .email("test@gmail.com")
                .picture("http://testPictureUrl.com")
                .role(Role.GUEST)
                .build();

        // When
        User savedUser = repository.save(user);

        // Then
        assertThat(savedUser.getName()).isEqualTo("테스터");
        assertThat(savedUser.getId()).isEqualTo(1L);
    }
}