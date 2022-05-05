package com.dariuszsurmacz.tictactoe.logic;

import java.util.Random;
import static com.dariuszsurmacz.tictactoe.Board.GRID_SIZE;

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
            int randomRow = random.nextInt(GRID_SIZE);
            int randomColumn = random.nextInt(GRID_SIZE);
            if (Player.BLANK == logicBoard.getSymbol(randomRow, randomColumn)) {
                return new BoardIndex(randomRow, randomColumn);
            }
        }
    }
}