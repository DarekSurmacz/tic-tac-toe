package com.dariuszsurmacz.tictactoe;

import java.util.Random;

public class EasyComputer implements Ai {

    private Random random;

    public EasyComputer() {
        random = new Random();
    }


    public BoardIndex calculateMove(LogicBoard logicBoard, Player player) {
        if (logicBoard.calculateGameState() != GameState.IN_PROGRESS) {
            return null;
        }
        while (true) {
            int randomRow = random.nextInt(3);
            int randomColumn = random.nextInt(3);
            if (Player.BLANK == logicBoard.getSymbol(randomRow, randomColumn)) {
                return new BoardIndex(randomRow, randomColumn);
            }
        }
    }
}