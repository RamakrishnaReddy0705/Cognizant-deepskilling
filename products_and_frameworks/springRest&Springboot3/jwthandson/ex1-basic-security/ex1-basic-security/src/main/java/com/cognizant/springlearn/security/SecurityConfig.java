package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Exercise 1: Simply enabling Spring Security.
 * With no overrides, Spring Boot auto-generates a default user "user"
 * and a random password that is printed in the console/log at startup.
 * Every endpoint (including /countries) now requires authentication.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    // No overrides yet - default behaviour:
    // - one in-memory user "user"
    // - randomly generated password logged at application startup, e.g.:
    //   "Using generated security password: d27321a9-0751-4f59-8fc6-f8633847a9b8"
}
