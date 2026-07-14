package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    private static final String SECRET_KEY = "secretkey123456789012345678901234567890";

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Authentication START");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String user = getUser(authHeader);
        LOGGER.debug("User extracted: {}", user);

        String token = generateJwt(user);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.info("Authentication END");
        return response;
    }

    private String getUser(String authHeader) {
        LOGGER.info("getUser START");
        String base64Credentials = authHeader.substring("Basic ".length()).trim();
        byte[] decoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decoded, StandardCharsets.UTF_8);

        String[] values = credentials.split(":", 2);
        LOGGER.debug("Decoded user: {}", values[0]);
        LOGGER.info("getUser END");
        return values[0];
    }

    private String generateJwt(String user) {
        LOGGER.info("generateJwt START");
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());

        builder.setExpiration(new Date(System.currentTimeMillis() + 1200000));
        builder.signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256);

        String token = builder.compact();
        LOGGER.info("generateJwt END");
        return token;
    }
}