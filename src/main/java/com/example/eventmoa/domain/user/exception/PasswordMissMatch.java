package com.example.eventmoa.domain.user.exception;

import com.example.eventmoa.global.error.exception.ErrorCode;
import com.example.eventmoa.global.error.exception.EventMoaException;

public class PasswordMissMatch extends EventMoaException {
    public final static EventMoaException EXCEPTION = new PasswordMissMatch();

    public PasswordMissMatch() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
