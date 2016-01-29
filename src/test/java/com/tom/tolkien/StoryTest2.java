package com.tom.tolkien;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.tom.tolkien.TestCharacterData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StoryTest2 {
    @Test
    public void shouldReturnHobbitCharacters() {
        List<Character> characters = Arrays.asList(BILBO, SAM, ARAGORN, GANDALF, FRODO);
        Story story = Story.builder().characters(characters).build();
        Set<Character> storyHobbits = story.charactersOf(Race.HOBBIT);
        assertThat(storyHobbits).containsOnly(BILBO, FRODO, SAM)
                                .extracting(Character::getRace)
                                .containsOnly(Race.HOBBIT);
    }
}