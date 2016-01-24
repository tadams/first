package com.tom.gamelife;

import java.util.Arrays;

import static com.tom.gamelife.GameOfLife.Status.*;

public class GameOfLife {

    enum Status { DEAD, ALIVE, OFF }

    public class Cell {

        Status status;
        int liveNeighborCount;

        public Cell(int x, int y) {
            status = cellStatus(x, y);
            countNeighbors(x - 1, y - 1, y, y + 1);
            countNeighbors(x, y - 1, y + 1);
            countNeighbors(x + 1, y - 1, y, y + 1);
        }

        public int nextGeneration() {
            switch (liveNeighborCount) {
                case 8:
                case 7:
                case 6:
                case 5:
                case 4:
                    return 0;
                case 3:
                    return 1;
                case 2:
                    return status == ALIVE ? 1 : 0;
                default:
                    return 0;
            }
        }

        private void countNeighbors(int x, int... yPositions) {
            for (int y : yPositions) {
                switch (cellStatus(x, y)) {
                    case ALIVE:
                        liveNeighborCount++;
                        break;
                    case DEAD:
                    case OFF:
                        break;
                }
            }
        }

        private Status cellStatus(int x, int y) {
            if (isValidPosition(x, y)) {
                return life[x][y] == 0 ? DEAD : ALIVE;
            }
            return OFF;
        }

        private boolean isValidPosition(int x, int y) {

            if (x < 0 || x >= life.length) {
                return false;
            }
            if (y < 0 || y >= life[x].length) {
                return false;
            }
            return true;
        }
    }

    int[][] life;

    public GameOfLife(int[][] seedLife) {
        life = seedLife;
    }

    public GameOfLife nextGeneration() {
        int[][] nextGenerationLife = new int[life.length][];

        for (int x=0; x < life.length; x++) {
            nextGenerationLife[x] = new int[life[x].length];

            for (int y=0; y < life[x].length; y++) {
                Cell cell = cell(x, y);
                nextGenerationLife[x][y] = cell.nextGeneration();
            }
        }

        return new GameOfLife(nextGenerationLife);
    }

    public Cell cell(int x, int y) {
        return new Cell(x, y);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        for (int[] row : life) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof GameOfLife) {
            int[][] otherLife = ((GameOfLife) other).life;
            return Arrays.deepEquals(life, otherLife);
        }
        return false;
    }

}
