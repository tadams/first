package com.tom.func;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SupplierMapTest {

    @Test
    public void shouldUseSupplierGeneratedValue() {
        Map<String, List<String>> testMap = new SupplierMap<>(ArrayList::new);
        assertEquals(0, testMap.size());
        List<String> list = testMap.get("A");
        assertEquals(0, list.size());
        assertEquals(1, testMap.size());
    }

}
