package com.dariuszsurmacz.tictactoe.logic;

import java.util.Random;

import static com.dariuszsurmacz.tictactoe.Board.GRID_SIZE;

public class MediumComputer implements Ai {

    private Random random;

    public MediumComputer() {
        random = new Random();
    }

    public BoardIndex calculateMove(LogicBoard logicBoard, Player player) {
        if (logicBoard.calculateGameState() != GameState.IN_PROGRESS) {
            return null;
        }
        //if srodkowe pole puste to tam stawiaj znak
        while (true) if (Player.BLANK == logicBoard.getSymbol(1, 1)) {
            return new BoardIndex(1, 1);
        } else {

            int randomRow = random.nextInt(GRID_SIZE);
            int randomColumn = random.nextInt(GRID_SIZE);
            if (Player.BLANK == logicBoard.getSymbol(randomRow, randomColumn)) {
                return new BoardIndex(randomRow, randomColumn);

            }
        }
    }
}

