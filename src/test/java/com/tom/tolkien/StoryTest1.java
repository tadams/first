package com.tom.tolkien;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static com.tom.tolkien.TestCharacterData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StoryTest1 {
    @Test
    public void shouldReturnHobbitCharacters() {
        List<Character> characters = new TestCharacterData().createList();
        Story story = Story.builder().characters(characters).build();

        Set<Character> storyHobbits = story.charactersOf(Race.HOBBIT);

        assertThat(storyHobbits).containsOnly(BILBO, FRODO, SAM)
                                .extracting(Character::getRace)
                                .containsOnly(Race.HOBBIT);
    }
}