package com.tom.func;

import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Supplier;

public class SupplierMap<K, V> extends HashMap<K, V> {

    private Supplier<V> supplier;

    public SupplierMap(Supplier<V> supplier) {
        this.supplier = supplier;
    }

    @Override
    public V get(Object key) {
        V value = super.get(key);
        if (value == null) {
            value = supplier.get();
            super.put((K)key, value);
        }
        return value;
//        Comparator
    }
}
