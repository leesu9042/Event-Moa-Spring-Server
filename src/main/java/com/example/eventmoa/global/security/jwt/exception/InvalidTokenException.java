package com.example.eventmoa.global.security.jwt.exception;

import com.example.eventmoa.global.error.exception.ErrorCode;
import com.example.eventmoa.global.error.exception.EventMoaException;

public class InvalidTokenException extends EventMoaException {
    public static final EventMoaException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
