package com.dariuszsurmacz.tictactoe;

import com.dariuszsurmacz.tictactoe.logic.Ai;

public class Board {

    public static final int GRID_SIZE = 3;
    public Tile[][] fields = new Tile[GRID_SIZE][GRID_SIZE];

    public Board(Ai ai) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                Tile tile = new Tile(FieldValue.EMPTY, ai);
                tile.setTranslateX(row * 200);
                tile.setTranslateY(column * 200);
                fields[row][column] = tile;
            }


        }
    }
}