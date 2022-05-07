package com.dariuszsurmacz.tictactoe.logic;

import com.dariuszsurmacz.tictactoe.BoardIndex;

import java.util.Random;

import static com.dariuszsurmacz.tictactoe.Board.GRID_SIZE;

public class MediumComputer implements Ai {

    private final Random random = new Random();

    public BoardIndex calculateMove(LogicBoard logicBoard, Player player) {
        if (logicBoard.calculateGameState() != GameState.IN_PROGRESS) {
            return null;
        }

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

