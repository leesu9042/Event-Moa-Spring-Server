package com.example.eventmoa.domain.user.service;

import com.example.eventmoa.domain.user.exception.PasswordMissMatch;
import com.example.eventmoa.domain.user.exception.UserNotFoundException;
import com.example.eventmoa.domain.user.persistence.User;
import com.example.eventmoa.domain.user.persistence.repository.UserRepository;
import com.example.eventmoa.domain.user.presentation.dto.request.UserLoginRequest;
import com.example.eventmoa.global.security.jwt.JwtProvider;
import com.example.eventmoa.global.security.jwt.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public TokenResponse login(UserLoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(UserNotFoundException::new);
        if(!request.getPassword().equals(user.getPassword())) {
            throw PasswordMissMatch.EXCEPTION;
        }
        return jwtProvider.generateToken(user.getId().toString(), user.getRole().toString());
    }
}
