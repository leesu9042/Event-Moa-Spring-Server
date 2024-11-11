package com.example.eventmoa.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_ALREADY_EXISTS(409, "Username Already Exists"),
    USER_NOT_FOUND(404,"존재하지 않는 유저입니다. "),
    PASSWORD_MISMATCH(401,"Password MisMatch"),
    ACCOUNTED_ALREADY_EXISTS(409, "AccountId Already Exists"),
    UNAUTHORIZED_USER(403,"권한이 부족한 유저입니다."),

    DEPARTMENT_NOT_FOUND(404,"존재하지 않는 과행사입니다."),
    DONG_NOT_FOUND(404,"존재하지 않는 동행사입니다."),

    INVALID_TOKEN(401,"Invalid Token."),
    EXPIRED_TOKEN(401, "Expired Token"),
    INTERNAL_SERVER_ERROR(500,"Internal Server Error");


    private final Integer status;
    private final String message;
}
