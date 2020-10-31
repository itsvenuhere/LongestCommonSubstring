package com.comcast.LongestCommonSubstring.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LCSResponse implements Serializable {

    private List<Value> lcs;

    public List<Value> getLcs() {
        if (null ==lcs){
            this.lcs = new ArrayList<>();
        }
        return lcs;
    }

    public void setLcs(List<Value> lcs) {
        this.lcs = lcs;
    }
}
