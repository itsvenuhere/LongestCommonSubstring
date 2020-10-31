package com.comcast.LongestCommonSubstring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "SetOfStrings must be unique")
public class UniqueConstraintException extends LCSException {
    public UniqueConstraintException(String message) {
        super(message);
    }
    public UniqueConstraintException(Throwable cause) { super(cause); }
    public UniqueConstraintException(String message, Throwable cause) { super(message, cause); }
}
