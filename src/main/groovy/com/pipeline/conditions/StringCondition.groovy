package com.pipeline.conditions

import groovy.transform.CompileStatic
import groovy.transform.ToString
import groovy.transform.TupleConstructor
import org.apache.commons.lang3.StringUtils

/**
 * Conditions for strings
 *
 * @author Travis Rasor
 */
@TupleConstructor
@ToString
@CompileStatic
class StringCondition extends ObjectCondition {

    final String string;


    StringCondition isNotBlankOrEmpty(String detail="") {
        if (StringUtils.isBlank(string) || StringUtils.isEmpty(string)) throwException("empty or not blank", detail);
        return this;
    }

    StringCondition isNotBlank(String detail="") {
        if (StringUtils.isBlank(string)) throwException("blank", detail);
        return this;
    }

    StringCondition isBlank(String detail="") {
        if (StringUtils.isNotBlank(string)) throwException("not blank", detail);
        return this;
    }

    StringCondition isNotEmpty(String detail="") {
        if (StringUtils.isEmpty(string)) throwException("not empty", detail);
        return this;
    }

    StringCondition isEmpty(String detail="") {
        if (StringUtils.isNotEmpty(string)) throwException("empty", detail);
        return this;
    }

    StringCondition isAllLowerCase(String detail="") {
        if (!StringUtils.isAllLowerCase(string)) throwException("not all lower case", detail);
        return this;
    }

    StringCondition isAllUpperCase(String detail="") {
        if (!StringUtils.isAllUpperCase(string))
            throw new ConditionViolationException("String [" + string + "] was not being all upper case", detail);
        return this;
    }

    StringCondition isAlpha(String detail="") {
        if (!StringUtils.isAlpha(string)) throwException("not only alphabetical characters", detail);
        return this;
    }

    StringCondition isAlphanumeric(String detail="") {
        if (!StringUtils.isAlphanumeric(string)) throwException("not alphanumeric", detail);
        return this;
    }

    private void throwException(String cause, String detail="") {
        def causeStr = "[$string] was $cause";
        throw new ConditionViolationException(causeStr, detail);
    }
}
