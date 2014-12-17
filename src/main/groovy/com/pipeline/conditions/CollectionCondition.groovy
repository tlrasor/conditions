package com.pipeline.conditions

import groovy.transform.CompileStatic
import groovy.transform.ToString
import groovy.transform.TupleConstructor

/**
 * A condition for collection types
 *
 * @author Travis Rasor
 */
@TupleConstructor
@ToString
@CompileStatic
class CollectionCondition extends ObjectCondition{

    final Collection collection;

    /**
     * Requires the collection to be empty
     */
    CollectionCondition isEmpty(String detail="") {
        if (!collection.isEmpty()) throw new ConditionViolationException("collection was not empty", detail);
        return this;
    }

    /**
     * Requires the collection to be not empty
     */
    CollectionCondition isNotEmpty(String detail="") {
        if (collection.isEmpty()) throw new ConditionViolationException("collection was empty", detail);
        return this;
    }

    /**
     * Requires the collection to be of a given size
     */
    CollectionCondition hasSize(int size, String detail="") {
        if (collection.size() != size) {
            throw new ConditionViolationException("collection size expected [$size] but actual [${collection.size()}]",
                    detail);
        }
        return this;
    }

    /**
     * Requires the collection contains a given element
     */
    CollectionCondition contains(Object obj, String detail="") {
        if (!collection.contains(obj))
            throw new ConditionViolationException("collection [$collection] did not contain [$obj]",
                detail);
        return this;
    }

    /**
     * Requires the collection contains no nulls
     */
    CollectionCondition containsNoNulls(String detail="") {
        for (Object o : collection)
            if (o == null)
                throw new ConditionViolationException("collection [$collection] contained a null object",
                        detail, new NullPointerException());
        return this;
    }
}
