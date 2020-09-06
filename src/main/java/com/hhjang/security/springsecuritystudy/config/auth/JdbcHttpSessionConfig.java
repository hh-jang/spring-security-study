package com.hhjang.security.springsecuritystudy.config.auth;

import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@EnableJdbcHttpSession(tableName = "USER_SESSION")
public class JdbcHttpSessionConfig {
}
