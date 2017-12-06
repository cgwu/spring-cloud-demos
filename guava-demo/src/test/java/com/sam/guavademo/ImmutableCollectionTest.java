package com.sam.guavademo;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by sam on 17-12-7.
 */
public class ImmutableCollectionTest {
    @Test
    public void testMap() {
        Map<Integer, String> map1 = ImmutableMap.of(3, "Three", 1, "one", 2, "two");
        for (Map.Entry<Integer, String> entry : map1.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
//        map1.put(4,"four"); // ERROR: java.lang.UnsupportedOperationException


//        MultiMap<Integer,String> map = new
//                ImmutableListMultimap.Builder<Integer,String>()
//                .put(1,"Foo")
//                .putAll(2,"Foo","Bar","Baz").build();

        System.out.println("----");
        Map<Integer, String> map2 = ImmutableMap.<Integer, String>builder()
                .put(3, "Three")
                .put(1, "One")
                .put(2, "Two")
                .put(300, "Three hundred")
                .put(100, "One hundred")
                .put(200, "Two hundred")
                .build();
        for (Map.Entry<Integer, String> entry : map2.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
//        map2.put(4,"four"); // ERROR: java.lang.UnsupportedOperationException

        System.out.println("----");
        Map<String, Integer> map3 = ImmutableMap.<String, Integer>builder()
                .put("Three", 3)
                .put("One", 1)
                .put("Two", 2)
                .put("Three hundred", 300)
                .put("One hundred", 100)
                .put("Two hundred", 200)
                .build();
        for (Map.Entry<String, Integer> entry : map3.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }


    @Test
    public void testArrayListMultimapSameKeyValue() {
        ArrayListMultimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("Bar", "1");
        multiMap.put("Bar", "2");
        multiMap.put("Bar", "3");
        multiMap.put("Bar", "3");
        multiMap.put("Bar", "3");
        multiMap.put("Foo", "100");
        multiMap.put("Foo", "300");
        List<String> expected = Lists.newArrayList("1", "2", "3", "3", "3");
        assertEquals(multiMap.get("Bar"), expected);
        System.out.println(expected);

        List<String> expectedFoo = Lists.newArrayList("100", "300");
        assertEquals(multiMap.get("Foo"), expectedFoo);
        System.out.println(expectedFoo);
    }


}
