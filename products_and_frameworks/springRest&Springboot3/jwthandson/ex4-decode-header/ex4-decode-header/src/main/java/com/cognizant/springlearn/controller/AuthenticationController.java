package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exercise 4: decode the Basic Authorization header to extract the username.
 */
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug("authHeader: {}", authHeader);

        String user = getUser(authHeader);
        LOGGER.debug("Resolved user: {}", user);

        Map<String, String> map = new HashMap<>();
        map.put("token", "");

        LOGGER.info("End");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.info("Start");
        String encodedCredentials = authHeader.replace("Basic ", "");
        String decoded = new String(Base64.getDecoder().decode(encodedCredentials));
        String user = decoded.substring(0, decoded.indexOf(":"));
        LOGGER.debug("Decoded credentials: {}", decoded);
        LOGGER.info("End");
        return user;
    }
}
