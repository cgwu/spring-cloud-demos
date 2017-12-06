package com.sam.guavademo;

import com.google.common.base.CharMatcher;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by sam on 17-12-6.
 */
public class CharMatcherTest {
    @Test
    public void testRemoveWhiteSpace() {
        String tabsAndSpaces = "String    with    spaces     and       tabs";
        String expected = "String with spaces and tabs";
        String scrubbed = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, ' ');
        assertThat(scrubbed, is(expected));
        System.out.println(scrubbed);
        tabsAndSpaces += "\n        新的一行";
        System.out.println(CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, ' '));
    }


    @Test
    public void testTrimRemoveWhiteSpace() {
        String tabsAndSpaces = "   String with spaces and tabs    ";
        String expected = "String with spaces and tabs";
        String scrubbed = CharMatcher.WHITESPACE.
                trimAndCollapseFrom(tabsAndSpaces, ' ');
        assertThat(scrubbed, is(expected));
    }

    @Test
    public void testRetainFrom() {
        String lettersAndNumbers = "foo989yxbar234";
        String expected = "989234";
        String retained = CharMatcher.JAVA_DIGIT.retainFrom(lettersAndNumbers);
        assertThat(expected, is(retained));
        System.out.println(retained);
    }


}
