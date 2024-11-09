package com.example.eventmoa.domain.user.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Schema
public class UserLoginRequest {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
