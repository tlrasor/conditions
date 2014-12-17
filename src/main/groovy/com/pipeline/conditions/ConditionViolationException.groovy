package com.pipeline.conditions

import groovy.transform.CompileStatic

/**
 * A exception indicating the failure of a condition
 *
 * @author Travis Rasor
 */
@CompileStatic
class ConditionViolationException extends RuntimeException {

    final String reason
    final String detail

    ConditionViolationException(String cause="", String detail=""){
        this.reason = cause
        this.detail = detail
    }

    ConditionViolationException(String cause="", String detail="", Throwable t) {
        super(t);
        this.reason = cause;
        this.detail = detail;
    }

    @Override
    public String getMessage() {
        "Cause: '${reason ?: ""}' Detail: '${detail ?: ""}'"
    }
}
