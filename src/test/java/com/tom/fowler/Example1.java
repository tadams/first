package com.tom.fowler;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static org.fest.assertions.Assertions.assertThat;

public class Example1 {

    EssayMother data   = new EssayMother();
    Set<Essay>  essays = data.getEssays();

    public List<Essay> findLargestNoSqlEssay() {

        return essays.stream()
                     .filter(essay -> essay.getTags().contains(EssayTag.NO_SQL))
                     .sorted(comparing(Essay::getWordCount).reversed())
                     .limit(3)
                     .collect(toList());
    }

    @Test
    public void shouldFilterAndFindLargestNoSqlEssays() {
        List<Essay> expected = Arrays.asList(data.ormHate,
                                             data.infoDeck,
                                             data.noDba);

        List<Essay> result = findLargestNoSqlEssay();
        assertThat(result).isEqualTo(expected);
    }
}
