package com.example.eventmoa.global.security.jwt;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "spring.jwt")
@AllArgsConstructor
@Getter
public class JwtProperty {
    private final String jwtSecret;
    private final Long accessExp;
    private final Long refreshExp;
    private final String header;
    private final String prefix;

}
