package com.pipeline.conditions

import org.junit.Test

/**
 * Created by travis on 12/17/14.
 */
class BooleanConditionTest {

    @Test
    void testIsTrue() throws Exception {
        Condition.that(true as boolean).isTrue();
    }

    @Test
    void testIsFalse() throws Exception {
        Condition.that(false as boolean).isFalse();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsTrue() throws Exception {
        Condition.that(false as boolean).isTrue();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsFalse() throws Exception {
        Condition.that(true as boolean).isFalse();
    }

}
