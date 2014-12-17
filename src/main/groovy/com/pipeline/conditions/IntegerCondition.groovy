package com.pipeline.conditions

import groovy.transform.CompileStatic
import groovy.transform.ToString
import groovy.transform.TupleConstructor


/**
 * Simple integer based conditions
 *
 * @author Travis Rasor
 */
@TupleConstructor
@ToString
@CompileStatic
class IntegerCondition extends Condition{

    final int num;

    IntegerCondition isEqualTo(int other, String detail="") {
        if (num != other) throwException("$other", num, detail);
        return this;
    }

    IntegerCondition isNotEqualTo(int other, String detail="") {
        if (num == other) throwException("! $other", num, detail);
        return this;
    }

    IntegerCondition isGreaterThan(int other, String detail="") {
        if (num <= other) throwException("> $other", num, detail);
        return this;
    }

    IntegerCondition isLessThan(int other, String detail="") {
        if (num >= other) throwException("< $other", num, detail);
        return this;
    }

    IntegerCondition isZero(String detail="") {
        return isEqualTo(0, detail);
    }

    IntegerCondition isNotZero(String detail="") {
        return isNotEqualTo(0, detail);
    }

    IntegerCondition isGreaterThanZero(String detail="") {
        return isGreaterThan(0, detail);
    }

    IntegerCondition isLessThanZero(String detail="") {
        return isLessThan(0, detail);
    }

    private void throwException(String expected, int received, String detail="") {
        throw new ConditionViolationException("expected value of $expected but received $received", detail);
    }
}
