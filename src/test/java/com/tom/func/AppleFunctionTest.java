package com.tom.func;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.tom.func.AppleFunction.AppleAction;

public class AppleFunctionTest {

    AppleAction resetWeight = new AppleAction() {
        @Override
        public void apply(Apple apple) {
            apple.setWeight(0.0);
        }
    };

    AppleAction printApple = new AppleAction() {
        @Override
        public void apply(Apple apple) {
            System.out.println(apple);
        }
    };

    List<Apple> apples = Arrays.asList(new Apple("red", 10.0),
                                       new Apple("green", 4.0),
                                       new Apple("yellow", 2.1));

    @Test
    public void shouldResetWeightAndPrintApple() {
        AppleFunction.apply(apples, resetWeight, printApple);
    }

}
