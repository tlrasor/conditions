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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

/**
 * @author Travis Rasor
 */
public class CollectionConditionTest {

    @Test
    public void testCapture() {
        Collection<Object> collection = Arrays.asList(new Object());
        CollectionCondition condition = CollectionCondition.that(collection);
        assertEquals(collection, condition.collection);
    }

    @Test(expected = ConditionViolationException.class)
    public void testDetailMessage() {
        try {
            Collection<Object> collection = Arrays.asList(new Object());
            CollectionCondition.that(collection).isEmpty("test detail");
        } catch (ConditionViolationException e) {
            assertTrue(e.getMessage().contains("test detail"));
            throw e;
        }
    }

    @Test
    public void testIsEmpty() throws Exception {
        Collection<Object> collection = Arrays.asList();
        CollectionCondition.that(collection).isEmpty();
    }

    @Test
    public void testIsNotEmpty() throws Exception {
        Collection<Object> collection = Arrays.asList(new Object());
        CollectionCondition.that(collection).isNotEmpty();
    }

    @Test
    public void testHasSize() throws Exception {
        Collection<Object> collection = Arrays.asList(new Object(), new Object(), new Object());
        CollectionCondition.that(collection).hasSize(3);
    }

    @Test
    public void testHasSizeZero() throws Exception {
        Collection<Object> collection = Arrays.asList();
        CollectionCondition.that(collection).hasSize(0);
    }

    @Test
    public void testContains() throws Exception {
        Object o = new Object();
        Collection<Object> collection = Arrays.asList(new Object(), o);
        CollectionCondition.that(collection).contains(o);
    }

    @Test
    public void testContainsNoNulls() throws Exception {
        Collection<Object> collection = Arrays.asList(new Object(), new Object());
        CollectionCondition.that(collection).containsNoNulls();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsEmpty() throws Exception {
        Collection<Object> collection = Arrays.asList(new Object());
        CollectionCondition.that(collection).isEmpty();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailIsNotEmpty() throws Exception {
        Collection<Object> collection = Arrays.asList();
        CollectionCondition.that(collection).isNotEmpty();
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailHasSize() throws Exception {
        Collection<Object> collection = Arrays.asList(new Object(), new Object());
        CollectionCondition.that(collection).hasSize(3);
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailContains() throws Exception {
        Object o = new Object();
        Collection<Object> collection = Arrays.asList(new Object());
        CollectionCondition.that(collection).contains(o);
    }

    @Test(expected = ConditionViolationException.class)
    public void testFailContainsNoNulls() throws Exception {
        Collection<Object> collection = Arrays.asList(new Object(), null, new Object());
        CollectionCondition.that(collection).containsNoNulls();
    }

}
