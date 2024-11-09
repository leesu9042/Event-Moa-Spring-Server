package com.example.eventmoa.domain.user.presentation;

import com.example.eventmoa.domain.user.persistence.repository.UserRepository;
import com.example.eventmoa.domain.user.presentation.dto.request.UserLoginRequest;
import com.example.eventmoa.domain.user.service.UserLoginService;
import com.example.eventmoa.domain.user.service.UserReissueService;
import com.example.eventmoa.global.security.jwt.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "auth controller", description = "로그인/ 토큰 재발급 api")
@RequestMapping("/auth")
public class UserController {
    private final UserLoginService userLoginService;
    private final UserReissueService userReissueService;

    @Operation(summary = "로그인 api")
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserLoginRequest request) {
        return userLoginService.login(request);
    }

    @Operation(summary = "토큰 재발급 api", description = "refresh-token을 헤더 key, refreshtoken(Bearer를 붙이지 않은)을 value로 해서 보내면 됩니다")
    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestHeader(name = "refresh-token") String token) {
        return userReissueService.reissue(token);
    }

}
