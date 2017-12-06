package com.sam.guavademo;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by sam on 17-12-6.
 */
public class SplitterTest {
    @Test
    public void Split() {
        String testString = "Monday,Tuesday,,Thursday,Friday,,";
        //parts is [Monday, Tuesday, , Thursday,Friday]
        String[] parts = testString.split(",");
        for (String part : parts) {
//            System.out.println(part);
            if (null == part) System.out.println("null");
            else if ("".equals(part)) System.out.println("empty");
            else System.out.println(part);
        }

        System.out.println("--------");
        Iterable<String> arr = Splitter.on(",").trimResults().split(testString);
        for (String a : arr) {
            if (null == a) System.out.println("null");
            else if ("".equals(a)) System.out.println("empty");
            else System.out.println(a);
        }

        System.out.println("--------");
    }

    @Test
    public void testSplitter() {
        String startString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Map<String, String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C", "Redskins");
        testMap.put("New York City", "Giants");
        testMap.put("Philadelphia", "Eagles");
        testMap.put("Dallas", "Cowboys");

        Splitter.MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");
        Map<String, String> splitMap = mapSplitter.split(startString); // 字符串分割成map
        assertThat(testMap, is(splitMap));
    }


}
