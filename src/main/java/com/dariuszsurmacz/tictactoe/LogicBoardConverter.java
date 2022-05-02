package com.dariuszsurmacz.tictactoe;

public class LogicBoardConverter {

    public LogicBoard convert(Board board, FieldValue humanPlayer) {
        LogicBoard logicBoard = new LogicBoard();
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                Tile currentTile = board.fields[i][j];
                Player convertedPlayer;

                if (currentTile.getFieldValue() == humanPlayer) {
                    convertedPlayer = Player.PLAYER;

                } else if (currentTile.getFieldValue() == FieldValue.EMPTY) {
                    convertedPlayer = Player.BLANK;

                } else {
                    convertedPlayer = Player.COMPUTER;
                }

                logicBoard.placeSymbol(i, j, convertedPlayer);
            }
        }
        return logicBoard;
    }
}