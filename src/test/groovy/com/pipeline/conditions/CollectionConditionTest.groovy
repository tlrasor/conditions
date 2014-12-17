package com.pipeline.conditions

import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by travis on 12/17/14.
 */
class CollectionConditionTest {

    @Test
    void testCapture() {
        Collection<Object> collection = Arrays.asList(new Object());
        CollectionCondition condition = Condition.that(collection);
        assert collection == condition.collection
    }


    @Test
    void testIsEmpty() throws Exception {
        Collection<Object> collection = Arrays.asList();
        Condition.that(collection).isEmpty();
    }

    @Test
    void testIsNotEmpty() throws Exception {
        Collection<Object> collection = Arrays.asList(new Object());
        Condition.that(collection).isNotEmpty();
    }

    @Test
    void testHasSize() throws Exception {
        Collection<Object> collection = Arrays.asList(new Object(), new Object(), new Object());
        Condition.that(collection).hasSize(3);
    }

    @Test
    void testHasSizeZero() throws Exception {
        Collection<Object> collection = Arrays.asList();
        Condition.that(collection).hasSize(0);
    }

    @Test
    void testContains() throws Exception {
        Object o = new Object();
        Collection<Object> collection = Arrays.asList(new Object(), o);
        Condition.that(collection).contains(o);
    }

    @Test
    void testContainsNoNulls() throws Exception {
        Collection<Object> collection = Arrays.asList(new Object(), new Object());
        Condition.that(collection).containsNoNulls();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsEmpty() throws Exception {
        Collection<Object> collection = Arrays.asList(new Object());
        Condition.that(collection).isEmpty();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailIsNotEmpty() throws Exception {
        Collection<Object> collection = Arrays.asList();
        Condition.that(collection).isNotEmpty();
    }

    @Test(expected = ConditionViolationException.class)
    void testFailHasSize() throws Exception {
        Collection<Object> collection = Arrays.asList(new Object(), new Object());
        Condition.that(collection).hasSize(3);
    }

    @Test(expected = ConditionViolationException.class)
    void testFailContains() throws Exception {
        Object o = new Object();
        Collection<Object> collection = Arrays.asList(new Object());
        Condition.that(collection).contains(o);
    }

    @Test(expected = ConditionViolationException.class)
    void testFailContainsNoNulls() throws Exception {
        Collection<Object> collection = Arrays.asList(new Object(), null, new Object());
        Condition.that(collection).containsNoNulls();
    }
}
