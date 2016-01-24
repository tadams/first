package com.tom.func;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import java.util.Objects;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class FirstNonNull {

    Integer quantity;
    Integer innerPackQuantity;
    Integer DEFAULT_QUANTITY = 1;

    @Test
    public void testDefaultPackageQuantity() {
        shouldReturnCorrectPackageQuantity(this::getPackageQuantity);
        shouldReturnCorrectPackageQuantity(this::getPackageQuantity2);
        shouldReturnCorrectPackageQuantity(this::getPackageQuantity3);
    }

    public void shouldReturnCorrectPackageQuantity(Supplier<Integer> testMethod) {
        quantity = null;
        innerPackQuantity = null;

        assertEquals(DEFAULT_QUANTITY, testMethod.get());
        innerPackQuantity = 2;
        assertEquals(innerPackQuantity, testMethod.get());
        quantity = 3;
        assertEquals(quantity, testMethod.get());
    }

    public Integer getPackageQuantity() {
        if (quantity != null) {
            return quantity;
        }
        if (innerPackQuantity != null) {
            return innerPackQuantity;
        }
        return DEFAULT_QUANTITY;
    }

    @Test
    public void shouldThrowNpe() {
        firstNonNull(null, null);
    }

    public Integer getPackageQuantity2() {
        return firstNonNull(quantity, innerPackQuantity, DEFAULT_QUANTITY);
    }

    public static <T> T firstNonNull(T... args) {
        return Stream.of(args)
                     .filter(Objects::nonNull)
                     .findFirst()
                     .get();
    }

    public Integer getPackageQuantity3() {
        return ObjectUtils.firstNonNull(quantity, innerPackQuantity, DEFAULT_QUANTITY);
    }

}
