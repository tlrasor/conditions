package com.pipeline.conditions

import groovy.transform.CompileStatic
import groovy.transform.ToString
import groovy.transform.TupleConstructor

/**
 * A condition for boolean checks
 *
 * @author Travis Rasor
 */
@TupleConstructor
@ToString
@CompileStatic
class BooleanCondition extends Condition {

    final boolean condition;

    BooleanCondition(boolean condition) {
        this.condition = condition;
    }

    /**
     * Requires that the statement evaluates to true
     */
    BooleanCondition isTrue(String detail="") {
        if (!condition) {
            throw new ConditionViolationException("boolean condition was false", detail, new IllegalStateException());
        }
        return this;
    }

    /**
     * Requires that the statement evaluates to false
     */
    BooleanCondition isFalse(String detail="") {
        if (condition) {
            throw new ConditionViolationException("boolean condition was true", detail, new IllegalStateException());
        }
        return this;
    }

}
