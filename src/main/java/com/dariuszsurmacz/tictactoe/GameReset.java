package com.dariuszsurmacz.tictactoe;

import com.dariuszsurmacz.tictactoe.logic.Ai;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.dariuszsurmacz.tictactoe.Board.GRID_SIZE;
import static com.dariuszsurmacz.tictactoe.TicTacToe.*;

public class GameReset {

    public static void gameReset() {
        gameReset(null);
    }

    public static void gameReset(Ai aiAlgorithm) {
        Tile[][] fields = board.fields;

        for (int column = 0; column < GRID_SIZE; column++) {
            for (int row = 0; row < GRID_SIZE; row++) {
                fields[row][column].setFieldValue(FieldValue.EMPTY);
                if (aiAlgorithm != null) {
                    fields[row][column].setAiAlgorithm(aiAlgorithm);
                }
                Rectangle node = (Rectangle) fields[row][column].getChildren().get(0);
                node.setFill(null);
            }
        }

        turnX = true;
        possibleMove = true;
        label.setText("X turn");
        label.setTextFill(Color.BLACK);
    }
}