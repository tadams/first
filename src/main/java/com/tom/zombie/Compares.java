package com.tom.zombie;

public interface Compares<T> extends Comparable<T> {

    default boolean isLessThan(T other) {
        return compareTo(other) < 0;
    }

    default boolean isGreaterThan(T other) {
        return compareTo(other) > 0;
    }

    default boolean isEqual(T other) {
        return compareTo(other) == 0;
    }
}
