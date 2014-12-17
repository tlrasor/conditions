package com.pipeline.conditions

import org.junit.Test

/**
 * Created by travis on 12/17/14.
 */
class IntegerConditionTest {

    @Test
    void testIsEqualTo() throws Exception {
        int i = 10;
        int j = 10;
        Condition.that(i).isEqualTo(j);
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsEqualTo() throws Exception {
        int i = 1;
        int j = 10;
        Condition.that(i).isEqualTo(j);
    }

    @Test
    void testIsNotEqualTo() throws Exception {
        int i = 1;
        int j = 10;
        Condition.that(i).isNotEqualTo(j);
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsNotEqualTo() throws Exception {
        int i = 10;
        int j = 10;
        Condition.that(i).isNotEqualTo(j);
    }

    @Test
    void testIsGreaterThan() throws Exception {
        int i = 10;
        int j = 9;
        Condition.that(i).isGreaterThan(j);
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsGreaterThan() throws Exception {
        int i = 1;
        int j = 9;
        Condition.that(i).isGreaterThan(j);
    }

    @Test
    void testIsLessThan() throws Exception {
        int i = 1;
        int j = 9;
        Condition.that(i).isLessThan(j);
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsLessThan() throws Exception {
        int i = 10;
        int j = 9;
        Condition.that(i).isLessThan(j);
    }

    @Test
    void testIsZero() throws Exception {
        int i = 0;
        Condition.that(i).isZero();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsZero() throws Exception {
        int i = 10;
        Condition.that(i).isZero();
    }

    @Test
    void testIsNotZero() throws Exception {
        int i = 10;
        Condition.that(i).isNotZero();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsNotZero() throws Exception {
        int i = 0;
        Condition.that(i).isNotZero();
    }

    @Test
    void testIsGreaterThanZero() throws Exception {
        int i = 10;
        Condition.that(i).isGreaterThanZero();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsGreaterThanZeroByZero() throws Exception {
        int i = 0;
        Condition.that(i).isGreaterThanZero();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsGreaterThanZeroByNegative() throws Exception {
        int i = -42;
        Condition.that(i).isGreaterThanZero();
    }

    @Test
    void testIsLessThanZero() throws Exception {
        int i = -10;
        Condition.that(i).isLessThanZero();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsLessThanZeroByZero() throws Exception {
        int i = 0;
        Condition.that(i).isLessThanZero();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsLessThanZeroByPositive() throws Exception {
        int i = 42;
        Condition.that(i).isLessThanZero();
    }
}
