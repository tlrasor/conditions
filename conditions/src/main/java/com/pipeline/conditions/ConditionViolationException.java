/**
 * Copyright Jun 9, 2012 Travis Rasor
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.pipeline.conditions;

import org.apache.commons.lang3.StringUtils;

/**
 * A exception indicating the failure of a condition
 * 
 * @author Travis Rasor
 */
public class ConditionViolationException extends RuntimeException {

    private static final long serialVersionUID = 12431456235L;

    private final String cause, detail;

    public ConditionViolationException() {
        this(null);
    }

    public ConditionViolationException(String cause) {
        this(null, null);
    }

    public ConditionViolationException(String cause, String detail) {
        this(cause, detail, null);
    }

    public ConditionViolationException(String cause, String detail, Throwable t) {
        super(t);
        this.cause = cause;
        this.detail = detail;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder(80);
        sb.append("Cause:");
        if (StringUtils.isNotBlank(cause)) sb.append("\'").append(cause).append("\'");
        if (StringUtils.isNotBlank(detail)) sb.append(" Detail:").append("\'").append(detail).append("\'");
        return sb.toString();
    }

    public String getCauseMessage() {
        return cause;
    }

    public String getDetailMessage() {
        return detail;
    }
}
