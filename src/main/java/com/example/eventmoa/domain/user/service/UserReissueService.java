package com.example.eventmoa.domain.user.service;


import com.example.eventmoa.domain.auth.RefreshToken;
import com.example.eventmoa.domain.auth.repository.RefreshTokenRepository;
import com.example.eventmoa.domain.user.persistence.User;
import com.example.eventmoa.domain.user.persistence.repository.UserRepository;
import com.example.eventmoa.global.security.jwt.JwtProperty;
import com.example.eventmoa.global.security.jwt.JwtProvider;
import com.example.eventmoa.global.security.jwt.TokenResponse;
import com.example.eventmoa.global.security.jwt.exception.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserReissueService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final JwtProperty jwtProperty;

    public TokenResponse reissue(String token) {
        boolean isTokenInvalid = !jwtTokenProvider.validToken(token);
        if(isTokenInvalid){
            throw InvalidTokenException.EXCEPTION;
        }
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token).orElseThrow(()->new RuntimeException("존재하지 않는 토큰"));
        User user = userRepository.findById((long) Integer.parseInt(refreshToken.getId())).orElseThrow();
        return jwtTokenProvider.generateToken(user.getUsername(),user.getRole().toString());
    }
}
