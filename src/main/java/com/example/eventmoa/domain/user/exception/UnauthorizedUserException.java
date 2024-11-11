package com.example.eventmoa.domain.user.exception;

import com.example.eventmoa.global.error.exception.ErrorCode;
import com.example.eventmoa.global.error.exception.EventMoaException;

public class UnauthorizedUserException extends EventMoaException {
    public final static EventMoaException EXCEPTION = new UnauthorizedUserException();

    public UnauthorizedUserException() {
        super(ErrorCode.UNAUTHORIZED_USER);
    }
}
