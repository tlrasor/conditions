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
public class StringConditionTest {

    @Test
    public void testIsNotBlankOrEmpty() throws Exception {
        String j = "jjj";
        new StringCondition(j).isNotBlankOrEmpty();
    }

    @Test
    public void testIsNotBlank() throws Exception {
        String j = "jjj";
        new StringCondition(j).isNotBlank();
    }

    @Test
    public void testIsBlank() throws Exception {
        String j = "   ";
        new StringCondition(j).isBlank();
    }

    @Test
    public void testIsNotEmpty() throws Exception {
        String j = "jjj";
        new StringCondition(j).isNotEmpty();
    }

    @Test
    public void testIsEmpty() throws Exception {
        String j = "";
        new StringCondition(j).isEmpty();
    }

    @Test
    public void testIsAllLowerCase() throws Exception {
        String j = "jjj";
        new StringCondition(j).isAllLowerCase();
    }

    @Test
    public void testIsAllUpperCase() throws Exception {
        String j = "JJJ";
        new StringCondition(j).isAllUpperCase();
    }

    @Test
    public void testIsAlpha() throws Exception {
        String j = "jjj";
        new StringCondition(j).isAlpha();
    }

    @Test
    public void testIsAlphanumeric() throws Exception {
        String j = "jjj123";
        new StringCondition(j).isAlphanumeric();
    }

}
