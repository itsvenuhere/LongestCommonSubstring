package com.comcast.LongestCommonSubstring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "SetOfStrings must present with atleast one value")
public class MissingPayloadException extends LCSException {
    public MissingPayloadException(String message) {
        super(message);
    }
    public MissingPayloadException(Throwable cause) { super(cause); }
    public MissingPayloadException(String message, Throwable cause) { super(message, cause); }
}
