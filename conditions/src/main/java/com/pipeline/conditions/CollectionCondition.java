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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A condition for collection types
 * 
 * @author Travis Rasor
 */
public class CollectionCondition extends ObjectCondition {

    final Collection<?> collection;

    CollectionCondition(Collection<?> collection) {
        super(collection);
        this.collection = collection;
    }

    /**
     * Requires the collection to be empty
     */
    public CollectionCondition isEmpty() {
        return isEmpty(null);
    }

    /**
     * Requires the collection to be empty
     */
    public CollectionCondition isEmpty(String detail) {
        if (!collection.isEmpty()) throw new ConditionViolationException("collection was not empty", detail);
        return this;
    }

    /**
     * Requires the collection to be not empty
     */
    public CollectionCondition isNotEmpty() {
        return isNotEmpty(null);
    }

    /**
     * Requires the collection to be not empty
     */
    public CollectionCondition isNotEmpty(String detail) {
        if (collection.isEmpty()) throw new ConditionViolationException("collection was empty", detail);
        return this;
    }

    /**
     * Requires the collection to be of a given size
     */
    public CollectionCondition hasSize(int size) {
        return hasSize(size, null);
    }

    /**
     * Requires the collection to be of a given size
     */
    public CollectionCondition hasSize(int size, String detail) {
        if (collection.size() != size)
            throw new ConditionViolationException(buildHasSizeCause(size, collection.size()), detail);
        return this;
    }

    private String buildHasSizeCause(int expected, int actual) {
        StringBuilder sb = new StringBuilder(50);
        sb.append("collection size expected [").append(expected).append("] but actual [").append(actual).append("]");
        return sb.toString();
    }

    /**
     * Requires the collection contains a given element
     */
    public CollectionCondition contains(Object obj) {
        return contains(obj, null);
    }

    /**
     * Requires the collection contains a given element
     */
    public CollectionCondition contains(Object obj, String detail) {
        if (!collection.contains(obj)) throw new ConditionViolationException(buildContainsCause(obj), detail);
        return this;
    }

    private String buildContainsCause(Object expected) {
        StringBuilder sb = new StringBuilder(80);
        sb.append("collection [").append(collection).append("] did not contain [").append(expected).append("]");
        return sb.toString();
    }

    /**
     * Requires the collection contains no nulls
     */
    public CollectionCondition containsNoNulls() {
        return containsNoNulls(null);
    }

    /**
     * Requires the collection contains no nulls
     */
    public CollectionCondition containsNoNulls(String detail) {
        for (Object o : collection)
            if (o == null)
                throw new ConditionViolationException(buildContainsNoNullsCause(), detail, new NullPointerException());
        return this;
    }

    private String buildContainsNoNullsCause() {
        StringBuilder sb = new StringBuilder(50);
        sb.append("collection [").append(collection).append("] contained a null object");
        return sb.toString();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.NO_FIELD_NAMES_STYLE).append(collection).build();
    }
}
