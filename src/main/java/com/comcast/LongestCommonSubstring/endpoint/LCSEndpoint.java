package com.comcast.LongestCommonSubstring.endpoint;

import com.comcast.LongestCommonSubstring.exception.UniqueConstraintException;
import com.comcast.LongestCommonSubstring.vo.LCSRequest;
import com.comcast.LongestCommonSubstring.vo.LCSResponse;

/**
 * LCS Endpoint to find the common longest substring
 */
public interface LCSEndpoint {

    /**
     *
     * @param lcsRequest
     * @return
     * @throws UniqueConstraintException
     */
    public LCSResponse findLongestCommonSubString(LCSRequest lcsRequest) throws UniqueConstraintException;
}
