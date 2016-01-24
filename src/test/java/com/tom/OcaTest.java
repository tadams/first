package com.tom;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OcaTest {

    @Test
    public void shouldSubstring() {
        assertThat("end".substring(0, 2), is("en"));
        assertThat("end".substring(0, 3), is("end"));
    }

    @Test
    public void shouldCompareStringBuilder() {
        StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder("abc");

        assertThat(sb1.equals(sb2), is(true));

    }

    @Test
    public void anotherExample() {
        String[] strings = { "stringValue" };
        Object[] objects = strings;
        String[] againStrings = (String[]) objects;
//        againStrings[0] = new StringBuilder();   // DOES NOT COMPILE
        objects[0] = new StringBuilder();        // careful!
    }

    @Test
    public void testLists() {
        List<String> birds = new ArrayList<>();
        birds.add("hawk");     // [hawk]
        birds.add("hawk");     // [hawk, hawk]
        System.out.println(birds.remove("cardinal")); // prints false
        System.out.println(birds.remove("hawk")); // prints true
        System.out.println(birds.remove(0)); // prints hawk
        System.out.println(birds);     // []
    }

    @Test(expected = UnsupportedTemporalTypeException.class)
    public void testPeriod() {
        LocalTime now = LocalTime.now();
        Period period = Period.ofDays(1);

        now.plus(period);
    }

    @Test
    public void testDuration() {
        LocalTime now = LocalTime.now();
        Duration duration = Duration.ofHours(5);
        String a = "string";
        a = "string" + new Date();
        int[][] foo = new int[1][];
        System.out.println(a);
    }

    @Test
    public void testArray() {
        List<Integer> ages = new ArrayList<>();
        ages.add(Integer.parseInt("5"));
        ages.add(Integer.valueOf("6"));
        ages.add(7);
        ages.add(null);
        for (Integer age : ages) System.out.print(age);
    }
}
