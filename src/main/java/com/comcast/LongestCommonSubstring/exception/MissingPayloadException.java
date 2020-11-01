package com.comcast.LongestCommonSubstring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
* Return 400 Bad request when setOfStrings doesn't exists in request payload. Since the request payload schema doesn't match returning 400.
*  TODO: Create new exception with status code 422, if request schema matches and can't process.
*/
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "SetOfStrings must present with atleast one value")
public class MissingPayloadException extends LCSException {
    public MissingPayloadException(String message) {
        super(message);
    }
    public MissingPayloadException(Throwable cause) { super(cause); }
    public MissingPayloadException(String message, Throwable cause) { super(message, cause); }
}
