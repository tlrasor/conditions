/**
 * Copyright Dec 9, 2012 Travis Rasor
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

import org.junit.Test;

/**
 * @author Travis Rasor
 */
public class IntegerConditionTest {

    @Test
    public void testIsEqualTo() throws Exception {
        int i = 10;
        int j = 10;
        IntegerCondition.that(i).isEqualTo(j);
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsEqualTo() throws Exception {
        int i = 1;
        int j = 10;
        IntegerCondition.that(i).isEqualTo(j);
    }

    @Test
    public void testIsNotEqualTo() throws Exception {
        int i = 1;
        int j = 10;
        IntegerCondition.that(i).isNotEqualTo(j);
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsNotEqualTo() throws Exception {
        int i = 10;
        int j = 10;
        IntegerCondition.that(i).isNotEqualTo(j);
    }

    @Test
    public void testIsGreaterThan() throws Exception {
        int i = 10;
        int j = 9;
        IntegerCondition.that(i).isGreaterThan(j);
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsGreaterThan() throws Exception {
        int i = 1;
        int j = 9;
        IntegerCondition.that(i).isGreaterThan(j);
    }

    @Test
    public void testIsLessThan() throws Exception {
        int i = 1;
        int j = 9;
        IntegerCondition.that(i).isLessThan(j);
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsLessThan() throws Exception {
        int i = 10;
        int j = 9;
        IntegerCondition.that(i).isLessThan(j);
    }

    @Test
    public void testIsZero() throws Exception {
        int i = 0;
        IntegerCondition.that(i).isZero();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsZero() throws Exception {
        int i = 10;
        IntegerCondition.that(i).isZero();
    }

    @Test
    public void testIsNotZero() throws Exception {
        int i = 10;
        IntegerCondition.that(i).isNotZero();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsNotZero() throws Exception {
        int i = 0;
        IntegerCondition.that(i).isNotZero();
    }

    @Test
    public void testIsGreaterThanZero() throws Exception {
        int i = 10;
        IntegerCondition.that(i).isGreaterThanZero();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsGreaterThanZeroByZero() throws Exception {
        int i = 0;
        IntegerCondition.that(i).isGreaterThanZero();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsGreaterThanZeroByNegative() throws Exception {
        int i = -42;
        IntegerCondition.that(i).isGreaterThanZero();
    }

    @Test
    public void testIsLessThanZero() throws Exception {
        int i = -10;
        IntegerCondition.that(i).isLessThanZero();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsLessThanZeroByZero() throws Exception {
        int i = 0;
        IntegerCondition.that(i).isLessThanZero();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsLessThanZeroByPositive() throws Exception {
        int i = 42;
        IntegerCondition.that(i).isLessThanZero();
    }

}
