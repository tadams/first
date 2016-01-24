package com.tom.fowler;

import lombok.Getter;

import java.util.*;

import static com.tom.fowler.EssayTag.*;
import static com.tom.fowler.EssayType.*;
import static java.util.Arrays.asList;
import static java.util.EnumSet.of;

public class EssayMother {

    @Getter
    Set<Essay> essays = new HashSet<>();

    Essay noDba    = Essay.builder().title("NoDBA")
                          .wordCount(561).type(BLIKI)
                          .tags(of(NO_SQL, PEOPLE, ORM))
                          .build();
    Essay infoDeck = Essay.builder().title("Infodeck")
                          .wordCount(1145).type(BLIKI)
                          .tags(of(NO_SQL, WRITING))
                          .build();
    Essay ormHate  = Essay.builder().title("OrmHate")
                          .wordCount(1718).type(BLIKI)
                          .tags(of(NO_SQL, ORM))
                          .build();
    Essay ruby     = Essay.builder().title("Ruby")
                          .wordCount(1313).type(ARTICLE)
                          .tags(of(RUBY))
                          .build();
    Essay ddd      = Essay.builder().title("DDD Aggregate")
                          .wordCount(482).type(BLIKI)
                          .tags(of(NO_SQL, DDD))
                          .build();

    public EssayMother() {
        essays.addAll(asList(noDba, infoDeck, ormHate, ruby, ddd));
    }
}
