/**
 * Copyright Jun 26, 2012 Travis Rasor
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
 * @author Travis Rasor
 */
public class IntegerCondition extends Condition {

    private final int num;

    public IntegerCondition(int num) {
        this.num = num;
    }

    public IntegerCondition isEqualTo(int other) {
        if (num != other) throwException(other, num);
        return this;
    }

    public IntegerCondition isNotEqualTo(int other) {
        if (num == other) throwException("!" + other, num);
        return this;
    }

    public IntegerCondition isGreaterThan(int other) {
        if (num <= other) throwException(">" + other, num);
        return this;
    }

    public IntegerCondition isLessThan(int other) {
        if (num >= other) throwException("<" + other, num);
        return this;
    }

    public IntegerCondition isZero() {
        return isEqualTo(0);
    }

    public IntegerCondition isNotZero() {
        return isNotEqualTo(0);
    }

    public IntegerCondition isGreaterThanZero() {
        return isGreaterThan(0);
    }

    public IntegerCondition isLessThanZero() {
        return isLessThan(0);
    }

    void throwException(String expected, int received) {
        throw new ConditionViolationException("expected value of " + expected + " but received " + received);
    }

    void throwException(int expected, int received) {
        throw new ConditionViolationException("expected value of " + expected + " but received " + received);
    }
}
