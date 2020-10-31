/**
 *
 */
package com.comcast.LongestCommonSubstring.service;

import com.comcast.LongestCommonSubstring.Settings;
import com.comcast.LongestCommonSubstring.exception.MissingPayloadException;
import com.comcast.LongestCommonSubstring.exception.UniqueConstraintException;
import com.comcast.LongestCommonSubstring.vo.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service implementation to find longest Common Substring
 */
@Service
public class LCSServiceImpl implements LCSService {
    private static final Logger logger = LoggerFactory.getLogger(LCSServiceImpl.class);

    @Autowired
    Settings settings;

    public Optional<Object>  findLongestCommonSubstring(List<Value> strList, String reqId) throws UniqueConstraintException {
        logger.info("START: LCSServiceImpl.findLongestCommonSubstring "+ reqId);
        long startTime = new Date().getTime();
        Optional<Object> longestCommonSubString = Optional.empty();
        Set<String> commonStrs =  new HashSet<>();

        if (null==strList || strList.size()==0){
            logger.error("setOfStrings should not be empty "+ reqId);
            throw new MissingPayloadException(settings.getMissingPayloadWarning());
        }else if (strList.size() ==1){
            commonStrs.add(strList.get(0).getValue());
            longestCommonSubString = longestCommonSubString.of(commonStrs);
        }else {
            //check if setOfStrings are unique or not
            validateIsSetOfStrings(strList, reqId);

            String shortestStr = strList.get(0).getValue().toString(), commonStr = "";
            for (Value eachValue: strList){
                shortestStr =  (eachValue.getValue().length() > eachValue.getValue().length() ? eachValue.getValue() : shortestStr);
            }

            for (int i = 0; i < shortestStr.length(); i++) {
                for (int j = i + 1; j <= shortestStr.length(); j++) {
                    String stem = shortestStr.substring(i, j);
                    int k = 1;
                    for (k = 1; k < strList.size(); k++)
                        if (!strList.get(k).getValue().contains(stem))
                            break;

                    if (k == strList.size()){
                        if(commonStr.length() < stem.length()) {
                            commonStr = stem;
                            commonStrs = new HashSet<>();
                            commonStrs.add(commonStr);
                        }else if (commonStr.length() == stem.length()){
                            commonStrs.add(stem);
                        }
                    }

                }
            }

            logger.debug("Common SubStrs:"+commonStrs);
            longestCommonSubString = longestCommonSubString.of(commonStrs);
        }

        logger.info("Complete: LCSServiceImpl.findLongestCommonSubstring in " + (new Date().getTime() - startTime) +" ms" + reqId);
        return longestCommonSubString;
    }

    /**
     * Validate if input strings are set
     * @param setOfStings
     * @param reqId
     * @throws UniqueConstraintException
     */
    private void validateIsSetOfStrings(List<Value> setOfStings, String reqId) throws UniqueConstraintException {
        logger.info("LCSServiceImpl: validateIsSetOfStrings" + reqId);
        HashSet<String> stringsSet = new HashSet();

        for (Value eachStr: setOfStings){
            if(!stringsSet.add(eachStr.getValue().toLowerCase())){
                logger.error("SetOfStrings must contain unique values" + reqId);
                throw new UniqueConstraintException(settings.getUniquePayloadWarning());
            }
        }
    }
}
