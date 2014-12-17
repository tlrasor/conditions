package com.pipeline.conditions

import org.junit.Test

/**
 * Created by travis on 12/17/14.
 */
class ObjectConditionTest {

    @Test
    void testIsNotEqualTo() throws Exception {
        ObjectCondition condition = new ObjectCondition("ob");
        condition.isNotEqualTo("other");
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsNotEqualTo() throws Exception {
        Object o = new Object();
        ObjectCondition condition = new ObjectCondition(o);
        condition.isNotEqualTo(o);
    }

    @Test
    void testIsEqualTo() throws Exception {
        Object o = new Object();
        ObjectCondition condition = new ObjectCondition(o);
        condition.isEqualTo(o);
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsEqualTo() throws Exception {
        Object o = new Object();
        Object t = new Object();
        ObjectCondition condition = new ObjectCondition(o);
        condition.isEqualTo(t);
    }

    @Test
    void testIsNull() throws Exception {
        Object o = null;
        ObjectCondition condition = new ObjectCondition(o);
        condition.isNull();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsNull() throws Exception {
        Object o = new Object();
        ObjectCondition condition = new ObjectCondition(o);
        condition.isNull();
    }

    @Test
    void testIsNotNull() throws Exception {
        Object o = new Object();
        ObjectCondition condition = new ObjectCondition(o);
        condition.isNotNull();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsNotNull() throws Exception {
        Object o = null;
        ObjectCondition condition = new ObjectCondition(o);
        condition.isNotNull();
    }
}
