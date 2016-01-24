package com.tom.zombie;

import org.junit.Test;

import static com.tom.zombie.Zombie.Type.FATTY;
import static com.tom.zombie.Zombie.Type.WALKER;
import static org.junit.Assert.assertTrue;

public class Zombie2Test {

    Zombie walker = new Zombie(WALKER);
    Zombie fatty  = new Zombie(FATTY);

    @Test
    public void shouldUseCompareMethods() {
        assertTrue(walker.isLessThan(fatty));
        assertTrue(fatty.isGreaterThan(walker));
        assertTrue(fatty.isEqual(fatty));
    }
}
