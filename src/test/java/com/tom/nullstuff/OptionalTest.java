package com.tom.nullstuff;

import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OptionalTest {

    Properties properties = new Properties();

    public OptionalTest() {
        properties.setProperty("a", "5");
        properties.setProperty("b", "true");
        properties.setProperty("c", "-3");
    }

    public Integer readDuration(Properties param, String key) {
        try {
            return Optional.of(param.get(key).toString())
                           .map(Integer::parseInt)
                           .filter(v -> v >= 0)
                           .orElse(0);

        } catch(NumberFormatException e) {
            return 0;
        }
    }

    @Test
    public void shouldReturnActualPositiveInteger() {
        assertThat(5, is(readDuration(properties, "a")));
    }

    @Test
    public void shouldReturnZeroForNegativeInteger() {
        assertThat(0, is(readDuration(properties, "c")));
    }

    @Test
    public void shouldZeroForNonNumeric() {
        assertThat(0, is(readDuration(properties, "b")));
    }
}
