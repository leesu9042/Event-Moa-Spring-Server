package com.example.eventmoa.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventMoaException extends RuntimeException {
    private final ErrorCode errorCode;
}
