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
 * Conditions for simple integer based conditions
 * 
 * @author Travis Rasor
 */
public class IntegerCondition extends Condition {

    private final int num;

    IntegerCondition(int num) {
        this.num = num;
    }

    public IntegerCondition isEqualTo(int other) {
        return isEqualTo(other, null);
    }

    public IntegerCondition isEqualTo(int other, String detail) {
        if (num != other) throwException(String.valueOf(other), num, detail);
        return this;
    }

    public IntegerCondition isNotEqualTo(int other) {
        return isNotEqualTo(other, null);
    }

    public IntegerCondition isNotEqualTo(int other, String detail) {
        if (num == other) throwException("!" + other, num, detail);
        return this;
    }

    public IntegerCondition isGreaterThan(int other) {
        return isGreaterThan(other, null);
    }

    public IntegerCondition isGreaterThan(int other, String detail) {
        if (num <= other) throwException(">" + other, num, detail);
        return this;
    }

    public IntegerCondition isLessThan(int other) {
        return isLessThan(other, null);
    }

    public IntegerCondition isLessThan(int other, String detail) {
        if (num >= other) throwException("<" + other, num, detail);
        return this;
    }

    public IntegerCondition isZero() {
        return isZero(null);
    }

    public IntegerCondition isZero(String detail) {
        return isEqualTo(0, detail);
    }

    public IntegerCondition isNotZero() {
        return isNotZero(null);
    }

    public IntegerCondition isNotZero(String detail) {
        return isNotEqualTo(0, detail);
    }

    public IntegerCondition isGreaterThanZero() {
        return isGreaterThanZero(null);
    }

    public IntegerCondition isGreaterThanZero(String detail) {
        return isGreaterThan(0, detail);
    }

    public IntegerCondition isLessThanZero() {
        return isLessThanZero(null);
    }

    public IntegerCondition isLessThanZero(String detail) {
        return isLessThan(0, detail);
    }

    private void throwException(String expected, int received, String detail) {
        throw new ConditionViolationException("expected value of " + expected + " but received " + received, detail);
    }

}