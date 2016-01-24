package com.tom.func;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;

public class Fibonnaci {

    @Test
    public void shouldGenerateFibonnaciNumbers() {
        List<int[]> expected = Arrays.asList(
                new int[] {0, 1},
                new int[] {1, 1},
                new int[] {1, 2},
                new int[] {2, 3},
                new int[] {3, 5}
                                             );
        generate();
        List<int[]> fibNumbers = generate(5);
        IntStream.range(0, 5).parallel()
                 .forEach(i -> assertTrue(Arrays.equals(expected.get(i), fibNumbers.get(i))));
    }

    public List<int[]> generate(int limit) {
        return Stream.iterate(new int[] {0,1}, t -> new int[] {t[1], t[0] + t[1]})
                     .limit(limit)
                     .collect(toList());
    }

    IntSupplier fib = new IntSupplier() {
        int prev = 0, curr = 1;
        @Override
        public int getAsInt() {
            int next = prev + curr;
            prev = curr;
            curr = next;
            curr = next;
            return prev;
        }
    };

    public List<Integer> generate() {
        IntStream.generate(fib).limit(10).forEach(System.out::println);
        return null;
    }
}
