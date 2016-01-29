package com.tom.tolkien;

import lombok.Getter;
import lombok.experimental.Builder;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Builder
@Getter
public class Story {

    List<Character> characters;

    public Set<Character> charactersOf(Race race) {
        return characters.stream()
                         .filter(character -> character.getRace() == race)
                         .collect(toSet());
    }
}
