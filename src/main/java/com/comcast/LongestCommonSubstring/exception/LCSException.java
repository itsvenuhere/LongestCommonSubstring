package com.comcast.LongestCommonSubstring.exception;

/**
 * Base exception for LongestCommonSubstring
 */
public class LCSException extends RuntimeException {

    public LCSException(String message) {
        super(message);
    }
    public LCSException(String message, Throwable cause) {
        super(message, cause);
    }
    public LCSException(Throwable cause) {
        super(cause);
    }
}
