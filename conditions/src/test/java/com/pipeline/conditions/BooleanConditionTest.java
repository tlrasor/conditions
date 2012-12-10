/**
 * Copyright Oct 14, 2012 Travis Rasor
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
public class BooleanConditionTest {

    @Test
    public void testIsTrue() throws Exception {
        BooleanCondition condition = new BooleanCondition(true);
        condition.isTrue();
    }

    @Test
    public void testIsFalse() throws Exception {
        BooleanCondition condition = new BooleanCondition(false);
        condition.isFalse();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsTrue() throws Exception {
        BooleanCondition condition = new BooleanCondition(false);
        condition.isTrue();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsFalse() throws Exception {
        BooleanCondition condition = new BooleanCondition(true);
        condition.isFalse();
    }

}
