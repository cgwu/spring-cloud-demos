package com.sam.guavademo;

import com.google.common.base.Charsets;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * Created by sam on 17-12-6.
 */
public class CharsetsTest {
    @Test
    public void charset(){
        byte[] data = "Hello中国".getBytes(StandardCharsets.UTF_8);
        byte[] data2 = "Hello中国".getBytes(Charsets.UTF_8); // deprecated
        System.out.println(data.length);
        System.out.println(data2.length);
    }
}
