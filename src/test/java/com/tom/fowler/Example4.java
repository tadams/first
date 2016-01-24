package com.tom.fowler;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class Example4 {

    EssayMother data   = new EssayMother();
    Set<Essay>  essays = data.getEssays();

    public void findArticleAndWordCountByTag() {

        essays.stream()
              .map(essay -> essay.getTags().stream()
                                 .collect(toMap(tag -> tag, e -> essay)))
              .map(Map::entrySet)
              .flatMap(Collection::stream)
              .collect(toMap(Map.Entry::getKey, e -> newTotal(e.getValue()),
                             Example4::addTotal))
              .entrySet()
              .forEach(System.out::println);
    }

    private static Map<String, Integer> newTotal(Object essay) {
        Map<String, Integer> totals = new HashMap<>();
        totals.put("Articles", 1);
        totals.put("Words", ((Essay)essay).getWordCount());
        return totals;
    }

    private static Map<String, Integer> addTotal(Map<String, Integer> totals,
                                                 Map<String, Integer> newTotals) {
        Integer articleCount = totals.get("Articles");
        Integer wordCount = totals.get("Words");
        Integer newWordCount = newTotals.get("Words");

        articleCount++;
        wordCount = wordCount + newWordCount;

        totals.put("Articles", articleCount);
        totals.put("Words", wordCount);

        return totals;
    }

    @Test
    public void shouldFilterAndFindLargestNoSqlEssays() {
        findArticleAndWordCountByTag();
//        List<Essay> expected = Arrays.asList(data.ormHate,
//                                             data.infoDeck,
//                                             data.noDba);
//
//        List<Essay> result = findLargestNoSqlEssay();
//        assertThat(result).isEqualTo(expected);
    }
}
