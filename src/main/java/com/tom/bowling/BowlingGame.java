package com.tom.bowling;

public class BowlingGame {

    protected int rolls[] = new int[20];
    protected int rollNumber = 0;

    enum Frame {
        STRIKE {
            @Override
            public int score(int[] rolls, int rollIndex) {
                return 10 + strikeBonus(rolls, rollIndex);
            }
        },
        SPARE {
            @Override
            public int score(int[] rolls, int rollIndex) {
                return 10 + spareBonus(rolls, rollIndex);
            }
        },
        PINS_REMAIN {
            @Override
            public int score(int[] rolls, int rollIndex) {
                return sumOfPinsDown(rolls, rollIndex);
            }
        };

        abstract int score(int[] rolls, int rollIndex);

        public static Frame classifyFrame(int firstRoll, int secondRoll) {
            if (firstRoll == 10) {
                return STRIKE;
            }
            if (firstRoll + secondRoll == 10) {
                return SPARE;
            }
            return PINS_REMAIN;
        }

        private static int spareBonus(int[] rolls, int rollIndex) {
            return rolls[rollIndex + 2];
        }

        private static int strikeBonus(int[] rolls, int rollIndex) {
            return rolls[rollIndex + 1] + rolls[rollIndex + 2];
        }

        private static int sumOfPinsDown(int[] rolls, int rollIndex) {
            return rolls[rollIndex] + rolls[rollIndex + 1];
        }

        public int nextRoll() {
            if (this == STRIKE) {
                return 1;
            }
            return 2;
        }
    }

    public void roll(int pinsKnockedDown) {
        rolls[rollNumber] = pinsKnockedDown;
        rollNumber++;
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < 10; frame++) {

            Frame frameType = Frame.classifyFrame(rolls[rollIndex], rolls[rollIndex + 1]);
            score += frameType.score(rolls, rollIndex);
            rollIndex += frameType.nextRoll();
        }
        return score;
    }
}
