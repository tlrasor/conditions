package com.pipeline.conditions

import org.junit.Test

/**
 * Created by travis on 12/17/14.
 */
class ConditionViolationExceptionTest{

    @Test(expected = ConditionViolationException.class)
    public void testDetailMessage() {
        try {
            Collection<Object> collection = Arrays.asList(new Object());
            CollectionCondition.that(collection).isEmpty("test detail");
        } catch (ConditionViolationException e) {
            assert e.getMessage().contains("test detail")
            throw e;
        }
    }
}
