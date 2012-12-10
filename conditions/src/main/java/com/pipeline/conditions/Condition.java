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

import java.util.Collection;

/**
 * @author Travis Rasor
 */
public class Condition {

    public static BooleanCondition that(boolean condition) {
        return new BooleanCondition(condition);
    }

    public static ObjectCondition that(Object obj) {
        return new ObjectCondition(obj);
    }

    public static CollectionCondition that(Collection<?> collection) {
        return new CollectionCondition(collection);
    }

    public static StringCondition that(String string) {
        return new StringCondition(string);
    }

    public static IntegerCondition that(int i) {
        return new IntegerCondition(i);
    }

    public BooleanCondition andThat(boolean expression) {
        return new BooleanCondition(expression);
    }

    public ObjectCondition andThat(Object obj) {
        return new ObjectCondition(obj);
    }

    public CollectionCondition andThat(Collection<?> collection) {
        return new CollectionCondition(collection);
    }

    public StringCondition andThat(String string) {
        return new StringCondition(string);
    }

    public IntegerCondition andThat(int i) {
        return new IntegerCondition(i);
    }
}
