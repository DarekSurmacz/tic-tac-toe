package com.dariuszsurmacz.tictactoe;

import com.dariuszsurmacz.tictactoe.logic.Ai;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.dariuszsurmacz.tictactoe.Board.GRID_SIZE;
import static com.dariuszsurmacz.tictactoe.TicTacToe.*;

public class State {

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

    public static Score gameResult() {
        Score result = null;
        Tile[][] fields = board.fields;

        for (int column = 0; column < GRID_SIZE; column++) {
            if (fields[0][column].getFieldValue() == fields[1][column].getFieldValue()
                    && fields[0][column].getFieldValue() == fields[2][column].getFieldValue()) {
                if (fields[0][column].getFieldValue() == FieldValue.CIRCLE) {
                    result = Score.O_WIN;
                    break;
                } else if (fields[0][column].getFieldValue() == FieldValue.CROSS) {
                    result = Score.X_WIN;
                    break;
                }
            }
        }
        if (result == null) {
            for (int row = 0; row < GRID_SIZE; row++) {
                if (fields[row][0].getFieldValue() == fields[row][1]
                        .getFieldValue()
                        && fields[row][0].getFieldValue() == fields[row][2].getFieldValue()) {
                    if (fields[row][0].getFieldValue() == FieldValue.CIRCLE) {
                        result = Score.O_WIN;
                        break;
                    } else if (fields[row][0].getFieldValue() == FieldValue.CROSS) {
                        result = Score.X_WIN;
                        break;
                    }
                }
            }
            if (result == null) {
                if (fields[0][0].getFieldValue() == fields[1][1].getFieldValue() &&
                        fields[0][0].getFieldValue() == fields[2][2].getFieldValue()) {
                    if (fields[0][0].getFieldValue() == FieldValue.CIRCLE) {
                        result = Score.O_WIN;
                    } else if (fields[0][0].getFieldValue() == FieldValue.CROSS) {
                        result = Score.X_WIN;
                    }
                }
                if (result == null) {
                    if (fields[2][0].getFieldValue() == fields[1][1].getFieldValue() &&
                            fields[2][0].getFieldValue() == fields[0][2].getFieldValue()) {
                        if (fields[2][0].getFieldValue() == FieldValue.CIRCLE) {
                            result = Score.O_WIN;
                        } else if (fields[2][0].getFieldValue() == FieldValue.CROSS) {
                            result = Score.X_WIN;
                        }
                    }
                    if (result == null) {
                        boolean isEmpty = false;
                        for (int row = 0; row < GRID_SIZE; row++) {
                            for (int column = 0; column < GRID_SIZE; column++) {
                                if (fields[row][column].getFieldValue() == FieldValue.EMPTY) isEmpty = true;
                            }
                        }
                        if (!isEmpty) {
                            result = Score.DRAW;
                        } else {
                            result = Score.IN_PROGRESS;
                        }
                    }
                }
            }
        }
        return result;
    }
}