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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Conditions for object references
 * 
 * @author Travis Rasor
 */
public class ObjectCondition extends Condition {

    private final Object object;

    public ObjectCondition(Object obj) {
        this.object = obj;
    }

    public ObjectCondition isNotNull() {
        return isNotNull(null);
    }

    public ObjectCondition isNotNull(String detail) {
        if (object == null)
            throw new ConditionViolationException("object was null", detail, new NullPointerException());
        return this;
    }

    public ObjectCondition isNull() {
        return isNull(null);
    }

    public ObjectCondition isNull(String detail) {
        if (object != null)
            throw new ConditionViolationException("object was not null", detail, new IllegalStateException());
        return this;
    }

    public ObjectCondition isEqualTo(Object other) {
        return isEqualTo(other, null);
    }

    public ObjectCondition isEqualTo(Object other, String detail) {
        if (!object.equals(other))
            throw new ConditionViolationException("object [" + object.toString() + "] was not equal to "
                    + other.toString(), detail, new IllegalStateException());
        return this;
    }

    public ObjectCondition isNotEqualTo(Object other) {
        return isNotEqualTo(other, null);
    }

    public ObjectCondition isNotEqualTo(Object other, String detail) {
        if (object.equals(other))
            throw new ConditionViolationException(
                    "object [" + object.toString() + "] was equal to " + other.toString(), detail,
                    new IllegalStateException());
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.NO_FIELD_NAMES_STYLE).append(object).build();
    }

}
