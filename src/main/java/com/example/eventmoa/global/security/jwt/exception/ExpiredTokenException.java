package com.example.eventmoa.global.security.jwt.exception;

import com.example.eventmoa.global.error.exception.ErrorCode;
import com.example.eventmoa.global.error.exception.EventMoaException;

public class ExpiredTokenException extends EventMoaException {
    public final static EventMoaException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
