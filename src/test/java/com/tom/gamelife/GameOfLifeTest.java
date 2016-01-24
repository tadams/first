package com.tom.gamelife;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {

    GameOfLife deadGame2x2 = new GameOfLife(new int[][]{{0,0},
                                                     {0,0}});
    GameOfLife deadGame3x3 = new GameOfLife(new int[][]
                   {{0,0,0},
                    {0,0,0},
                    {0,0,0}});


    @Test
    public void shouldKnowIfGamesAreEqual() {
        GameOfLife game = new GameOfLife(new int[][]{{0,0},
                                                     {0,1}});
        assertEquals(game, game);
    }

    @Test
    public void shouldReturnDeadGameWhenOneLiveCellInSeed() {
        GameOfLife game = new GameOfLife(new int[][]
                {{0,0},
                 {0,1}});
        GameOfLife nextGen = game.nextGeneration();
        assertEquals(deadGame2x2, nextGen);
    }

    @Test
    public void shouldReturnDeadCenterWhenFourLiveNeighbors() {
        GameOfLife game = new GameOfLife(new int[][]
                {{1,0,1},
                 {0,1,0},
                 {1,0,1}});

        GameOfLife.Cell cell = game.cell(1, 1);
        assertEquals(0, cell.nextGeneration());
    }

    @Test
    public void shouldTrackGameMultipleGenerations() {
        GameOfLife game = new GameOfLife(new int[][]
                       {{1,0,1},
                        {0,1,0},
                        {1,0,1}});
        GameOfLife expected1 = new GameOfLife(new int[][]
                       {{0,1,0},
                        {1,0,1},
                        {0,1,0}});

        GameOfLife nextGen1 = game.nextGeneration();
        assertEquals(expected1, nextGen1);

        GameOfLife nextGen2 = nextGen1.nextGeneration();
        assertEquals(expected1, nextGen2);
    }

    @Test
    public void shouldNotChangeStaticSeedPositions() {
        GameOfLife game = new GameOfLife(new int[][]
                       {{1,1,0},
                        {1,1,0},
                        {0,0,0}});

        GameOfLife nextGen1 = game.nextGeneration();
        assertEquals(game, nextGen1);

        GameOfLife nextGen2 = nextGen1.nextGeneration();
        assertEquals(game, nextGen2);
    }
}
