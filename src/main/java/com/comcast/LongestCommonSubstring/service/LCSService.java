package com.comcast.LongestCommonSubstring.service;


import com.comcast.LongestCommonSubstring.exception.UniqueConstraintException;
import com.comcast.LongestCommonSubstring.vo.Value;
import java.util.List;
import java.util.Optional;


/**
 * Service to find the LCS, in given set of values
 */
public interface LCSService {

    /**
     * To find the longest common substring in the given list of values
     *
     * @param strList
     * @return Optional<String> - longest common substring
     */
    public Optional<Object> findLongestCommonSubstring(List<Value> strList, String reqId) throws UniqueConstraintException;
}
