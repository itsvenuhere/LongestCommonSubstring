package com.comcast.LongestCommonSubstring.vo;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * LCS request object to have set of Strings
 *
 */
@XmlRootElement
public class LCSRequest implements Serializable {

    /**
     * For now, not using spring validation framework. Instead validating manually.
     */
    //@NotNull(message ="setOfStrings must be present to identify longest common substring")
    //@Size(min = 1, message = "{sizeOfStrings.required.minLength}")
    private List<Value> setOfStrings;

    public List<Value> getSetOfStrings() {
        return setOfStrings;
    }

    @XmlElement
    public void setSetOfStrings(List<Value> setOfStrings) {
        this.setOfStrings = setOfStrings;
    }
}
