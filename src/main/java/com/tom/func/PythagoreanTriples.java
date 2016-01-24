package com.tom.func;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriples {

    Stream<int[]> triples;

    public static void main(String[] args) {
        PythagoreanTriples pythagoreanTriples = new PythagoreanTriples();
        pythagoreanTriples.generateTriples();

        pythagoreanTriples.triples.forEach(t -> System.out.println(Arrays.toString(t)));
    }

    public void generateTriples() {

        triples = IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                               .filter(b -> squareRoot(a, b) % 1 == 0)
                                               .boxed()
                                               .map(b -> new int[] {a, b, (int) squareRoot(a, b)}));
    }

    private double squareRoot(Integer a, int b) {
        return Math.sqrt(a*a + b*b);
    }
}
