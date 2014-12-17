package com.pipeline.conditions

/**
 * Base class for conditions. Used to chain multiple checks together.
 *
 * @author Travis Rasor
 */
class Condition {
    
    static BooleanCondition that(boolean condition) {
        new BooleanCondition(condition);
    }

    static ObjectCondition that(Object obj) {
        new ObjectCondition(obj);
    }

    static CollectionCondition that(Collection collection) {
        new CollectionCondition(collection);
    }

    static StringCondition that(String string) {
        new StringCondition(string);
    }

    static IntegerCondition that(int i) {
        new IntegerCondition(i);
    }

    BooleanCondition andThat(boolean expression) {
        new BooleanCondition(expression);
    }

    ObjectCondition andThat(Object obj) {
        new ObjectCondition(obj);
    }

    CollectionCondition andThat(Collection<?> collection) {
        new CollectionCondition(collection);
    }

    StringCondition andThat(String string) {
        new StringCondition(string);
    }

    IntegerCondition andThat(int i) {
        new IntegerCondition(i);
    }

}
