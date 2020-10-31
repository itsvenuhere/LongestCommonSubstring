package com.comcast.LongestCommonSubstring.service;

import com.comcast.LongestCommonSubstring.Settings;
import com.comcast.LongestCommonSubstring.exception.MissingPayloadException;
import com.comcast.LongestCommonSubstring.exception.UniqueConstraintException;
import com.comcast.LongestCommonSubstring.vo.Value;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { LCSServiceImpl.class, Settings.class})
public class LCSServiceImplTest {

    @Autowired
    LCSService lcsService;

    @Autowired
    Settings settings;

    @Test
    @Tag("regression")
    public void testEmptyStrings(){
        Exception exception = Assertions.assertThrows(MissingPayloadException.class, () -> {
            lcsService.findLongestCommonSubstring(new ArrayList<>(), UUID.randomUUID().toString());
        });

        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(settings.getMissingPayloadWarning()));
    }

    @Test
    @Tag("regression")
    public void testNonSetStrings(){
        List<Value> inputStrs = new ArrayList();
        Value value1 = new Value();

        value1.setValue("Comcast");
        inputStrs.add(value1);

        value1 = new Value();
        value1.setValue("comacastic");
        inputStrs.add(value1);

        value1 = new Value();
        value1.setValue("comcast");
        inputStrs.add(value1);


        Exception exception = Assertions.assertThrows(UniqueConstraintException.class, () -> {
            lcsService.findLongestCommonSubstring(inputStrs, UUID.randomUUID().toString());
        });

        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(settings.getUniquePayloadWarning()));
    }

    @Test
    @Tag("regression")
    public void testPositiveScenario_onestring(){
        List<Value> inputStrs = new ArrayList();
        Value value1 = new Value();

        value1.setValue("Comcast");
        inputStrs.add(value1);

        Optional<Object> output = lcsService.findLongestCommonSubstring(inputStrs, UUID.randomUUID().toString());
        Assertions.assertTrue(output.get().toString().contains("Comcast"));
    }

    @Test
    @Tag("regression")
    public void testPositiveScenario_emptyLCS(){
        List<Value> inputStrs = new ArrayList();
        Value value1 = new Value();

        value1.setValue("Comcast");
        inputStrs.add(value1);

        value1 = new Value();
        value1.setValue("BNY");
        inputStrs.add(value1);

        Optional<Object> output = lcsService.findLongestCommonSubstring(inputStrs, UUID.randomUUID().toString());
          HashSet set = (HashSet) output.get();
          Assertions.assertTrue(set.size()==0);

    }
}
