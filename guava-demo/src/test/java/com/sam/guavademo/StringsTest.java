package com.sam.guavademo;

import com.google.common.base.Strings;
import org.junit.Test;

/**
 * Created by sam on 17-12-6.
 */
public class StringsTest {
    @Test
    public void pad(){
        String res =  Strings.padEnd("foo",6,'x');
        System.out.println(res);
        res =  Strings.padStart("foo",6,'x');
        System.out.println(res);
        res =  Strings.padStart("foobar",6,'x');
        System.out.println(res);

        String s=null;
        System.out.println(Strings.isNullOrEmpty(s));
        s = "";
        System.out.println(Strings.isNullOrEmpty(s));
    }
}
