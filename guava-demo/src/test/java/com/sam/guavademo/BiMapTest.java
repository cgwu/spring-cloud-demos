package com.sam.guavademo;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by sam on 17-12-6.
 */
public class BiMapTest {
    @Test
    public void testBiMapInverse() throws Exception {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "Tom");
        biMap.put("2", "Harry");
        assertThat(biMap.get("1"), is("Tom"));
        assertThat(biMap.get("2"), is("Harry"));
        System.out.println(biMap);

        BiMap<String, String> inverseMap = biMap.inverse();
        assertThat(inverseMap.get("Tom"), is("1"));
        assertThat(inverseMap.get("Harry"), is("2"));
        System.out.println(inverseMap);

        inverseMap.put("Tom", "3");
        inverseMap.put("Tom", "4"); // key可以重复塞
//        inverseMap.put("Harrya", "2"); // error
        inverseMap.forcePut("Harrya", "2"); // 强制更新
        System.out.println(inverseMap);
    }

}
