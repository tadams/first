package com.tom.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest4 {

    BowlingGame4 game;

    @Before
    public void given() {
        game = new BowlingGame4();
    }

    @Test
    public void shouldScoreGutterBallGame() {
        rollBall(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void shouldScoreOnePinDownPerRollGame() {
        rollBall(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void shouldScoreGameWithOneSpare() {
        rollSpare();
        game.roll(3);
        rollBall(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void shouldScoreGameWithOneStrike() {
        game.roll(10);
        game.roll(2);
        game.roll(3);
        rollBall(16, 0);
        assertEquals(20, game.score());
    }

    @Test
    public void shouldScorePerfectGame() {
        rollBall(12, 10);
        assertEquals(300, game.score());
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollBall(int rolls, int pinsKnockedDown) {
        for (int i=0; i < rolls; i++) {
            game.roll(pinsKnockedDown);
        }
    }
}
