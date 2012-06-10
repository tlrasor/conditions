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
public class CollectionCondition extends ObjectCondition {

    final Collection<?> collection;

    public CollectionCondition(Collection<?> collection) {
        super(collection);
        this.collection = collection;
    }

    public CollectionCondition isEmpty() {
        if (!collection.isEmpty())
            throw new ConditionViolationException("collection violated condition by being populated");
        return this;
    }

    public CollectionCondition isNotEmpty() {
        if (collection.isEmpty())
            throw new ConditionViolationException("collection violated condition by being empty");
        return this;
    }

    public CollectionCondition hasSize(int size) {
        if (collection.size() != size)
            throw new ConditionViolationException("collection violated condition by of incorrect size");
        return this;
    }

    public CollectionCondition contains(Object obj) {
        if (!collection.contains(obj))
            throw new ConditionViolationException("collection violated condition by of incorrect size");
        return this;
    }

    public CollectionCondition areAllNotNull() {
        for (Object o : collection)
            Condition.that(o).isNotNull();
        return this;
    }

    public CollectionCondition containsNoNulls() {
        for (Object o : collection)
            Condition.that(o).isNotNull();
        return this;
    }
}
