package com.sam.guavademo;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by sam on 17-12-6.
 */
public class JoinerTest {
    @Test
    public void join() {
        String res = Joiner.on("|").join("Hello", "中国");
        System.out.println(res);
        List<String> listStr = new ArrayList<String>();
        listStr.add("Hello");
        listStr.add("Hello2");
        listStr.add("Hello3");
        System.out.println(Joiner.on(',').join(listStr));
        listStr.add(null);
        System.out.println(Joiner.on(',').skipNulls().join(listStr));
        System.out.println(Joiner.on(',').useForNull("no value").join(listStr));

        StringBuilder sb = new StringBuilder("abc");
        Joiner joiner = Joiner.on(":");
        joiner.appendTo(sb, "foo", "bar", "baz");
        System.out.println(sb);

    }

    @Test
    public void testMapJoiner() {
        // Using LinkedHashMap so that the original order is preserved
        String expectedString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Map<String, String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C", "Redskins");
        testMap.put("New York City", "Giants");
        testMap.put("Philadelphia", "Eagles");
        testMap.put("Dallas", "Cowboys");

        String returnedString = Joiner.on("#").withKeyValueSeparator("=").join(testMap);
        assertThat(returnedString, is(expectedString)); // TODO: assertThat usage?
        assertEquals(returnedString,expectedString);
        System.out.println(returnedString);
    }


}
