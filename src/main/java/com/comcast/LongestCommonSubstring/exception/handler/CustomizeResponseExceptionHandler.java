package com.comcast.LongestCommonSubstring.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exceptionhandler to handle all runtime exceptions and return corresponding response code
 */
@RestController
@ControllerAdvice
public class CustomizeResponseExceptionHandler extends ResponseEntityExceptionHandler {


}
