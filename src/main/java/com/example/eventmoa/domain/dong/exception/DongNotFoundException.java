package com.example.eventmoa.domain.dong.exception;

import com.example.eventmoa.global.error.exception.ErrorCode;
import com.example.eventmoa.global.error.exception.EventMoaException;

public class DongNotFoundException extends EventMoaException {
    public final static EventMoaException EXCEPTION = new  DongNotFoundException();

    public DongNotFoundException() {
        super(ErrorCode.DONG_NOT_FOUND);
    }
}
