package com.dariuszsurmacz.tictactoe.logic;

import static com.dariuszsurmacz.tictactoe.Board.GRID_SIZE;

public class LogicBoard {

    private Player grid[][];

    public LogicBoard() {
        grid = new Player[GRID_SIZE][GRID_SIZE];
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                grid[row][column] = Player.BLANK;
            }
        }
    }

    public boolean placeSymbol(int row, int column, Player player) {
        if (grid[row][column] != Player.BLANK)
            return false;

        grid[row][column] = player;
        return true;
    }

    public Player getSymbol(int row, int column) {
        return grid[row][column];
    }

    public GameState calculateGameState() {

        for (int column = 0; column < GRID_SIZE; column++) {
            if (grid[0][column] == grid[1][column]
                    && grid[0][column] == grid[2][column]) {
                if (grid[0][column] == Player.COMPUTER) {
                    return GameState.COMPUTER_WIN;

                } else if (grid[0][column] == Player.PLAYER) {
                    return GameState.PLAYER_WIN;
                }
            }
        }

        for (int row = 0; row < GRID_SIZE; row++) {
            if (grid[row][0] == grid[row][1]
                    && grid[row][0] == grid[row][2]) {
                if (grid[row][0] == Player.COMPUTER) {
                    return GameState.COMPUTER_WIN;

                } else if (grid[row][0] == Player.PLAYER) {
                    return GameState.PLAYER_WIN;
                }
            }
        }

        if (grid[0][0] == grid[1][1] &&
                grid[0][0] == grid[2][2]) {
            if (grid[0][0] == Player.COMPUTER) {
                return GameState.COMPUTER_WIN;

            } else if (grid[0][0] == Player.PLAYER) {
                return GameState.PLAYER_WIN;
            }
        }

        if (grid[2][0] == grid[1][1] &&
                grid[2][0] == grid[0][2]) {
            if (grid[2][0] == Player.COMPUTER) {
                return GameState.COMPUTER_WIN;

            } else if (grid[2][0] == Player.PLAYER) {
                return GameState.PLAYER_WIN;
            }
        }

        boolean isEmpty = false;
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (grid[row][column] == Player.BLANK) {
                    isEmpty = true;
                }
            }
        }

        if (!isEmpty) {
            return GameState.DRAW;
        }
        return GameState.IN_PROGRESS;
    }
}