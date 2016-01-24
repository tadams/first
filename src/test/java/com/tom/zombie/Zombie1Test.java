package com.tom.zombie;

import org.junit.Test;

import static com.tom.zombie.Zombie.Type.FATTY;
import static com.tom.zombie.Zombie.Type.WALKER;
import static org.junit.Assert.assertTrue;

public class Zombie1Test {

    Zombie walker = new Zombie(WALKER);
    Zombie fatty  = new Zombie(FATTY);

    @Test
    public void shouldUseCompareMethods() {
        assertTrue(walker.compareTo(fatty) < 0);
        assertTrue(fatty.compareTo(walker) > 0);
        assertTrue(fatty.compareTo(fatty) == 0);
    }
}
