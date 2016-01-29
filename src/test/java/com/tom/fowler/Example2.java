package com.tom.fowler;

import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Example2 {

    EssayMother data   = new EssayMother();
    Set<Essay>  essays = data.getEssays();

    public int calculateTotalWordCount() {

        return essays.stream()
                     .mapToInt(Essay::getWordCount)
                     .sum();
    }

    public int calculateTotalWordCount2() {

        return essays.stream()
                     .mapToInt(Essay::getWordCount)
                     .reduce((total, wordCount) -> total + wordCount)
                     .getAsInt();
    }

    @Test
    public void shouldTotalWordCount_UsingSum() {
        int expected = 5_219;

        int totalWordCount = calculateTotalWordCount();
        assertThat(totalWordCount).isEqualTo(expected);
    }

    @Test
    public void shouldTotalWordCount_UsingReduce() {
        int expected = 5_219;

        int totalWordCount = calculateTotalWordCount2();
        assertThat(totalWordCount).isEqualTo(expected);
    }
}
