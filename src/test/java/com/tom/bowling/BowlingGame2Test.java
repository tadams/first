package com.tom.bowling;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BowlingGame2Test {

    BowlingGame2 game;

    @Before
    public void given() {
        game = new BowlingGame2();
    }

    @Test
    public void shouldScoreGameWhereEachRollKnockedDownOnePin() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void shouldScoreGutterGame() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void shouldScoreGameWithOneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void shouldScoreGameWithTwoSpares() {
        rollSpare();
        rollSpare();
        rollMany(15, 1);
        assertEquals(41, game.score());
    }

    @Test
    public void shouldScoreGameWithOneStrike() {
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int rollCount, int pinsKnockedDown) {
        for (int i=0; i < rollCount; i++) {
            game.roll(pinsKnockedDown);
        }
    }
}
