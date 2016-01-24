package com.tom.bowling;

import java.util.function.BiFunction;

public class BowlingGame4 {

    public static final int MAX_PINS = 10;

    public enum FrameType {
        STRIKE((rolls, frameIndex) -> MAX_PINS + rolls[frameIndex+1] + rolls[frameIndex+2],
               1),
        SPARE((rolls, frameIndex) -> MAX_PINS + rolls[frameIndex+2],
               2),
        OPEN((rolls, frameIndex) -> rolls[frameIndex] + rolls[frameIndex+1],
               2);

        private BiFunction<int[], Integer, Integer> scoreFunction;

        private int rollsInFrame;

        private FrameType(BiFunction<int[], Integer, Integer> scoreFunction,
                          int rollsInFrame) {
            this.scoreFunction = scoreFunction;
            this.rollsInFrame  = rollsInFrame;
        }

        public static FrameType classifyFrame(int firstRoll, int secondRoll) {
            if (firstRoll == MAX_PINS) {
                return STRIKE;
            }
            if (firstRoll + secondRoll == MAX_PINS) {
                return SPARE;
            }
            return OPEN;
        }

        public int scoreFrame(int[] rolls, int frameIndex) {
            return scoreFunction.apply(rolls, frameIndex);
        }
        public int rollsInFrame() {
            return rollsInFrame;
        }
    }

    int[] rolls = new int[21];
    int rollIndex = 0;

    public void roll(int pinsKnockedDown) {
        rolls[rollIndex] = pinsKnockedDown;
        rollIndex++;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;

        for (int frame = 0; frame < MAX_PINS; frame++) {

            FrameType frameType = FrameType.classifyFrame(rolls[frameIndex], rolls[frameIndex + 1]);
            score += frameType.scoreFrame(rolls, frameIndex);
            frameIndex += frameType.rollsInFrame();

        }
        return score;
    }
}
