package com.comcast.LongestCommonSubstring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * This spring singleton class will load environment specific application properties.
 */
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Settings {
    @Value("${lcs.default.requestPayload}")
    private String defaultSamplePayload;


    @Value("${lcs.default.missingPayload}")
    private String missingPayloadWarning;

    @Value("${lcs.default.unique.requestPayload}")
    private String uniquePayloadWarning;

    public String getDefaultSamplePayload() {
        return defaultSamplePayload;
    }

    public void setDefaultSamplePayload(String defaultSamplePayload) {
        this.defaultSamplePayload = defaultSamplePayload;
    }

    public String getMissingPayloadWarning() {
        return missingPayloadWarning;
    }

    public void setMissingPayloadWarning(String missingPayloadWarning) {
        this.missingPayloadWarning = missingPayloadWarning;
    }

    public String getUniquePayloadWarning() {
        return uniquePayloadWarning;
    }

    public void setUniquePayloadWarning(String uniquePayloadWarning) {
        this.uniquePayloadWarning = uniquePayloadWarning;
    }
}
