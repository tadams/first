package com.tom.func;

import java.util.List;
import java.util.function.Function;

public class AppleFunction {

    public interface AppleAction {
        public void apply(Apple apple);
    }

    public static void apply(List<Apple> apples, AppleAction... actions) {
        for (Apple apple : apples) {
            doActions(apple, actions);
        }
    }

    private static void doActions(Apple apple, AppleAction... actions) {
        for (AppleAction action : actions) {
            action.apply(apple);
        }
    }

    public static void doIt(Function<String, Integer> func) {
        func.apply("foo");
    }
}
