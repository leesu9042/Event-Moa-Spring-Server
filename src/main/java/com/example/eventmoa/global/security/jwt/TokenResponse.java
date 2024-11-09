package com.example.eventmoa.global.security.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@RequiredArgsConstructor
public class TokenResponse {
    private final String accessToken;

    private final String refreshToken;
}
