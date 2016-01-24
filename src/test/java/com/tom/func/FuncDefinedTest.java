package com.tom.func;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class FuncDefinedTest {

    FuncDefined funcDefined = new FuncDefined();

    String prefix = "p1";

    Function<String, String> prefixFunction = s -> s + prefix;

    BiPredicate<List<String>, String> exists = List::contains;

    Map<String, String> map = new HashMap<>();

    @Test
    public void shouldAddPrefix() {
        String prefix = "used?";
        String result = prefixFunction.apply("test");
        assertEquals("testp1", result);
    }
}
