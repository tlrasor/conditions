/**
 * Copyright Feb 18, 2013 Travis Rasor
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

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

/**
 * @author Travis Rasor
 */
public class ConditionViolationExceptionTest {

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
}
