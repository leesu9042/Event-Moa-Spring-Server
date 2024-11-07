package com.example.eventmoa.global.error;

import com.example.eventmoa.global.error.exception.ErrorCode;
import com.example.eventmoa.global.error.exception.EventMoaException;

public class ExceptionException extends EventMoaException {
    public static final EventMoaException EXCEPTION = new ExceptionException();
    public ExceptionException() {
        super(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
