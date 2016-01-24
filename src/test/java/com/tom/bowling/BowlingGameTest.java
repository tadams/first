package com.tom.bowling;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void given() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void shouldScoreZeroForGutterGame() {
        roll(20, 0);
        assertEquals(0, bowlingGame.score());
    }

    @Test
    public void shouldScoreGameWhereEachFrameOnePinIsKnockedDown() {
        roll(20, 1);
        assertEquals(20, bowlingGame.score());
    }

    @Test
    public void shouldScoreOneSpare() {
        rollSpare();
        bowlingGame.roll(3);
        roll(17, 0);
        assertEquals(16, bowlingGame.score());
    }

    @Test
    public void shouldScoreOneStrike() {
        rollStrike();
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        roll(17, 0);
        assertEquals(24, bowlingGame.score());
    }

    @Test
    public void shouldScorePerfectGame() {
        roll(12,10);
        assertEquals(300, bowlingGame.score());
    }

    private void rollStrike() {
        bowlingGame.roll(10);
    }

    private void rollSpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }

    private void roll(int frameCount, int pinsToKnockDown) {
        for (int i=0; i < frameCount; i++) {
            bowlingGame.roll(pinsToKnockDown);
        }
    }

}
