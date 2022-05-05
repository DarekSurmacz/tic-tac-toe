package com.dariuszsurmacz.tictactoe.logic;

import com.dariuszsurmacz.tictactoe.Board;
import com.dariuszsurmacz.tictactoe.FieldValue;
import com.dariuszsurmacz.tictactoe.Tile;

import static com.dariuszsurmacz.tictactoe.Board.GRID_SIZE;

public class LogicBoardConverter {

    public LogicBoard convert(Board board, FieldValue humanPlayer) {
        LogicBoard logicBoard = new LogicBoard();
        for (int row = 0; row < GRID_SIZE; row++) {

            for (int column = 0; column < GRID_SIZE; column++) {
                Tile currentTile = board.fields[row][column];
                Player convertedPlayer;

                if (currentTile.getFieldValue() == humanPlayer) {
                    convertedPlayer = Player.PLAYER;

                } else if (currentTile.getFieldValue() == FieldValue.EMPTY) {
                    convertedPlayer = Player.BLANK;

                } else {
                    convertedPlayer = Player.COMPUTER;
                }

                logicBoard.placeSymbol(row, column, convertedPlayer);
            }
        }
        return logicBoard;
    }
}