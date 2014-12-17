package com.pipeline.conditions

import org.junit.Test

/**
 * Created by travis on 12/17/14.
 */
class StringConditionTest {

    @Test
    void testIsNotBlankOrEmpty() throws Exception {
        String j = "jjj";
        Condition.that(j).isNotBlankOrEmpty();
    }

    @Test
    void testIsNotBlank() throws Exception {
        String j = "jjj";
        Condition.that(j).isNotBlank();
    }

    @Test
    void testIsBlank() throws Exception {
        String j = "   ";
        Condition.that(j).isBlank();
    }

    @Test
    void testIsNotEmpty() throws Exception {
        String j = "jjj";
        Condition.that(j).isNotEmpty();
    }

    @Test
    void testIsEmpty() throws Exception {
        String j = "";
        Condition.that(j).isEmpty();
    }

    @Test
    void testIsAllLowerCase() throws Exception {
        String j = "jjj";
        Condition.that(j).isAllLowerCase();
    }

    @Test
    void testIsAllUpperCase() throws Exception {
        String j = "JJJ";
        Condition.that(j).isAllUpperCase();
    }

    @Test
    void testIsAlpha() throws Exception {
        String j = "jjj";
        Condition.that(j).isAlpha();
    }

    @Test
    void testIsAlphanumeric() throws Exception {
        String j = "jjj123";
        Condition.that(j).isAlphanumeric();
    }

}
