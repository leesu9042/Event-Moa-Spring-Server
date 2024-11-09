package com.example.eventmoa.domain.user.presentation;

import com.example.eventmoa.domain.user.persistence.repository.UserRepository;
import com.example.eventmoa.domain.user.presentation.dto.request.UserLoginRequest;
import com.example.eventmoa.domain.user.service.UserLoginService;
import com.example.eventmoa.global.security.jwt.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {
    private final UserLoginService userLoginService;
    @PostMapping("/login")
    public TokenResponse login(UserLaoginRequest request) {
        return userLoginService.login(request);
    }

}
