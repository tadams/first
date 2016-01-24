package com.tom.bowling;

import static com.tom.bowling.BowlingGame3.FrameType.classifyFrame;

public class BowlingGame3 {

    public static final int MAX_PINS = 10;

    public enum FrameType {
        STRIKE {
            public int scoreFrame(int rolls[], int frameIndex) {
                return MAX_PINS + rolls[frameIndex+1] + rolls[frameIndex+2];
            }
            public int rollsInFrame() {
                return 1;
            }
        },
        SPARE {
            public int scoreFrame(int rolls[], int frameIndex) {
                return MAX_PINS + rolls[frameIndex+2];
            }
            public int rollsInFrame() {
                return 2;
            }
        },
        OPEN {
            public int scoreFrame(int rolls[], int frameIndex) {
                return rolls[frameIndex] + rolls[frameIndex+1];
            }
            public int rollsInFrame() {
                return 2;
            }
        };

        public static FrameType classifyFrame(int firstRoll, int secondRoll) {
            if (firstRoll == MAX_PINS) {
                return STRIKE;
            }
            if (firstRoll + secondRoll == MAX_PINS) {
                return SPARE;
            }
            return OPEN;
        }

        public abstract int scoreFrame(int[] rolls, int frameIndex);
        public abstract int rollsInFrame();
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

            FrameType frameType = classifyFrame(rolls[frameIndex], rolls[frameIndex + 1]);
            score += frameType.scoreFrame(rolls, frameIndex);
            frameIndex += frameType.rollsInFrame();
        }
        return score;
    }
}
