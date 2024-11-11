package com.example.eventmoa.domain.department.exception;

import com.example.eventmoa.global.error.exception.ErrorCode;
import com.example.eventmoa.global.error.exception.EventMoaException;

public class DepartmentNotFoundException extends EventMoaException {
    public static final EventMoaException EXCEPTION = new DepartmentNotFoundException();

    public DepartmentNotFoundException() {
        super(ErrorCode.DEPARTMENT_NOT_FOUND);
    }
}
