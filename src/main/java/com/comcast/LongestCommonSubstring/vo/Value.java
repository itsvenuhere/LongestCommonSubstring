package com.comcast.LongestCommonSubstring.vo;

import javax.validation.constraints.NotNull;

/**
 * Pojo to have Value in request and responses. For now, having same object for both request and response.
 */
public class Value {
    @NotNull(message ="value is required attribute")
    private Object value;

    public String getValue() {
        if(null!=value){
            return value.toString().trim();
        }
        return null;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
