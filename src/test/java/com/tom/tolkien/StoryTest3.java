package com.tom.tolkien;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static com.tom.tolkien.TestCharacterData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StoryTest3 {
    @Test
    public void shouldReturnHobbitCharacters() {
        List<Character> characters = new TestCharacterData().fellowshipOfTheRing();
        Story story = Story.builder().characters(characters).build();
        Set<Character> fellowshipOfRingHobbits = story.charactersOf(Race.HOBBIT);
        assertThat(fellowshipOfRingHobbits).containsOnly(FRODO, SAM, MERRY, PIPPIN)
                                           .extracting(Character::getRace)
                                           .containsOnly(Race.HOBBIT);
    }
}