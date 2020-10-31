package com.comcast.LongestCommonSubstring.endpoint;

import com.comcast.LongestCommonSubstring.Settings;
import com.comcast.LongestCommonSubstring.exception.ExceptionResponse;
import com.comcast.LongestCommonSubstring.exception.MissingPayloadException;
import com.comcast.LongestCommonSubstring.exception.UniqueConstraintException;
import com.comcast.LongestCommonSubstring.service.LCSService;
import com.comcast.LongestCommonSubstring.vo.LCSRequest;
import com.comcast.LongestCommonSubstring.vo.LCSResponse;
import com.comcast.LongestCommonSubstring.vo.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.*;

/**
 * LCSEndpointImpl to find the common longest substring in given set of strings
 *
 *  Validations -
 *      if given strings are null/empty --> Return 400 - Bad request
 *      If given strings is not a set --> Return 406 -- Unique constraint exception
 *
 * Returns -
 *      Set of longest common substrings. Min length of substring can be 1.
 *
 */
@RestController
public class LCSEndpointImpl implements LCSEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(LCSEndpointImpl.class);

    @Autowired
    LCSService lcsService;

    @Autowired
    Settings settings;

    @PostMapping("lcs")
    public LCSResponse findLongestCommonSubString(@Valid @RequestBody LCSRequest lcsRequest) throws UniqueConstraintException {
        UUID reqId = UUID.randomUUID();
        logger.info("START: LCSEndpointImpl.findLongestCommonSubString " + reqId.toString());
        long startTime = new Date().getTime();

        validateReqPayload(lcsRequest, reqId.toString()); // Validating missing payload here for now, instead of performing in interceptors

        LCSResponse response =  new LCSResponse();
        Optional<Object> longestCommonSubStr = lcsService.findLongestCommonSubstring(lcsRequest.getSetOfStrings(),  reqId.toString());

        if (longestCommonSubStr.isPresent() && longestCommonSubStr.get() instanceof HashSet){
            HashSet<String> responseStrs =  new HashSet<String>((Collection<? extends String>) longestCommonSubStr.get());
            Value value = null;

            for (String responseStr: responseStrs){
                value = new Value();
                value.setValue(responseStr);
                response.getLcs().add(value);
            }
        }

        logger.info("Complete: LCSEndpointImpl.findLongestCommonSubString in " + (new Date().getTime() - startTime) +" ms " + reqId.toString());
        return response;
    }

    private void validateReqPayload(LCSRequest lcsRequest, String reqId) throws MissingPayloadException{
        logger.info("Validating LCS request payload " + reqId);
        if (null ==lcsRequest || lcsRequest.getSetOfStrings() == null || lcsRequest.getSetOfStrings().size() <1){
            throw new MissingPayloadException(settings.getMissingPayloadWarning());
        }
    }

    /**
     * For now handling the exceptions in controller, will move these to exception mappers/handlers.
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(UniqueConstraintException.class)
    public final ResponseEntity<ExceptionResponse> handleHttpMediaTypeNotAcceptable(UniqueConstraintException ex, WebRequest request) {
        logger.error("LCSEndpointImpl:handleHttpMediaTypeNotAcceptable");
        ExceptionResponse response = new ExceptionResponse(new Date(), settings.getDefaultSamplePayload(), ex.getMessage(), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase(), HttpStatus.NOT_ACCEPTABLE.value()+"");
        return new ResponseEntity(response, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MissingPayloadException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequest(MissingPayloadException ex, WebRequest request) {
        logger.error("LCSEndpointImpl:handleBadRequest");
        ExceptionResponse response = new ExceptionResponse(new Date(), settings.getDefaultSamplePayload(), ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST.value()+"");
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

}
