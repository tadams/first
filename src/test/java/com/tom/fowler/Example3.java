package com.tom.fowler;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Example3 {

    EssayMother data   = new EssayMother();
    Set<Essay>  essays = data.getEssays();

    public Map<EssayType, Long> calculateEssayTypeCount() {

        return essays.stream()
                     .collect(
                      groupingBy(Essay::getType,
                                 counting()));

    }

    public Map<EssayType, Integer> calculateEssayTypeCount2() {

        return essays.stream()
                     .collect(
                             groupingBy(Essay::getType,
                                        reducing(0, essay -> 1, Integer::sum)));

    }

    @Test
    public void shouldFilterAndFindLargestNoSqlEssays() {
        Map<EssayType, Long> expected = new HashMap<>();
        expected.put(EssayType.ARTICLE, 1L);
        expected.put(EssayType.BLIKI, 4L);

        Map<EssayType, Long> essayTypeCount = calculateEssayTypeCount();
        assertThat(essayTypeCount).isEqualTo(expected);
    }

    @Test
    public void shouldFilterAndFindLargestNoSqlEssays2() {
        Map<EssayType, Integer> expected = new HashMap<>();
        expected.put(EssayType.ARTICLE, 1);
        expected.put(EssayType.BLIKI, 4);

        Map<EssayType, Integer> essayTypeCount = calculateEssayTypeCount2();
        assertThat(essayTypeCount).isEqualTo(expected);
    }
}
