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

import static org.junit.Assert.fail;

/**
 * @author Travis Rasor
 */
public class ObjectConditionTest {


    @Test
    public void testIsNotEqualTo() throws Exception {
        ObjectCondition condition = new ObjectCondition("ob");
        condition.isNotEqualTo("other");
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsNotEqualTo() throws Exception {
        Object o = new Object();
        ObjectCondition condition = new ObjectCondition(o);
        condition.isNotEqualTo(o);
    }

    @Test
    public void testIsEqualTo() throws Exception {
        Object o = new Object();
        ObjectCondition condition = new ObjectCondition(o);
        condition.isEqualTo(o);
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsEqualTo() throws Exception {
        Object o = new Object();
        Object t = new Object();
        ObjectCondition condition = new ObjectCondition(o);
        condition.isEqualTo(t);
    }

    @Test
    public void testIsNull() throws Exception {
        Object o = null;
        ObjectCondition condition = new ObjectCondition(o);
        condition.isNull();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsNull() throws Exception {
        Object o = new Object();
        ObjectCondition condition = new ObjectCondition(o);
        condition.isNull();
    }

    @Test
    public void testIsNotNull() throws Exception {
        Object o = new Object();
        ObjectCondition condition = new ObjectCondition(o);
        condition.isNotNull();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsNotNull() throws Exception {
        Object o = null;
        ObjectCondition condition = new ObjectCondition(o);
        condition.isNotNull();
    }

}
