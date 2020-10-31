package com.comcast.LongestCommonSubstring.exception;

import java.util.Date;

public class ExceptionResponse {

    private Date timeStampe;
    private String samplePayload;
    private String error;
    private String message;
    private String status;

    public ExceptionResponse(Date timeStampe, String samplePayload, String error, String message, String status) {
        this.timeStampe = timeStampe;
        this.samplePayload = samplePayload;
        this.error = error;
        this.message = message;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public Date getTimeStampe() {
        return timeStampe;
    }

    public String getSamplePayload() {
        return samplePayload;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
