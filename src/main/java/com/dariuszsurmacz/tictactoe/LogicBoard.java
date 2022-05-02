package com.dariuszsurmacz.tictactoe;

public class LogicBoard {

    private Player grid[][];

    public LogicBoard() {
        grid = new Player[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = Player.BLANK;
            }
        }
    }

    public boolean placeSymbol(int i, int j, Player player) {
        if (grid[i][j] != Player.BLANK)
            return false;

        grid[i][j] = player;
        return true;
    }

    public Player getSymbol(int i, int j) {
        return grid[i][j];
    }

    public GameState calculateGameState() {

        for (int j = 0; j < 3; j++) {
            if (grid[0][j] == grid[1][j]
                    && grid[0][j] == grid[2][j]) {
                if (grid[0][j] == Player.COMPUTER) {
                    return GameState.COMPUTER_WIN;

                } else if (grid[0][j] == Player.PLAYER) {
                    return GameState.PLAYER_WIN;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1]
                    && grid[i][0] == grid[i][2]) {
                if (grid[i][0] == Player.COMPUTER) {
                    return GameState.COMPUTER_WIN;

                } else if (grid[i][0] == Player.PLAYER) {
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
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (grid[x][y] == Player.BLANK) {
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