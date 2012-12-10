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

/**
 * A condition for boolean checks
 * 
 * @author Travis Rasor
 */
public class BooleanCondition extends Condition {

    private final boolean condition;

    public BooleanCondition(boolean condition) {
        this.condition = condition;
    }

    /**
     * Requires that the statement evaluates to true
     */
    public BooleanCondition isTrue() {
        if (!condition) {
            throw new ConditionViolationException("boolean condition was false", new IllegalStateException());
        }
        return this;
    }

    /**
     * Requires that the statement evaluates to false
     */
    public BooleanCondition isFalse() {
        if (condition) {
            throw new ConditionViolationException("boolean condition was true", new IllegalStateException());
        }
        return this;
    }

    @Override
    public String toString() {
        return "BooleanCondition [condition=" + condition + "]";
    }
}
