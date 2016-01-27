package com.pipeline.conditions

import groovy.transform.CompileStatic
import groovy.transform.ToString
import groovy.transform.TupleConstructor

/**
 * Conditions for object references
 *
 * @author Travis Rasor
 */
@TupleConstructor
@ToString
@CompileStatic
class ObjectCondition extends Condition {

    final Object object;

    ObjectCondition isNotNull(String detail="") {
        if (object == null)
            throw new ConditionViolationException("object was null", detail, new NullPointerException());
        return this;
    }

    ObjectCondition isNull(String detail="") {
        if (object != null)
            throw new ConditionViolationException("object was not null", detail, new IllegalStateException());
        return this;
    }

    ObjectCondition isEqualTo(Object other, String detail="") {
        if (!object.equals(other))
            throw new ConditionViolationException("object [${object.toString()}] was not equal to ${other.toString()}",
                    detail, new IllegalStateException());
        return this;
    }

    ObjectCondition isNotEqualTo(Object other, String detail="") {
        if (object.equals(other))
            throw new ConditionViolationException(
                    "object [${object.toString()}] was equal to ${ other.toString()}", detail,
                    new IllegalStateException());
        return this;
    }
}
