package com.dariuszsurmacz.tictactoe;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {



    private static Image cross = new Image("file:src/main/resources/x.png");
    private static Image circle = new Image("file:src/main/resources/o.png");
    private Ai aiAlgorithm;
    private FieldValue fieldValue;

    public FieldValue getFieldValue() {
        return fieldValue;
    }

    public void setAiAlgorithm(Ai aiAlgorithm) {
        this.aiAlgorithm = aiAlgorithm;

    }

    public void setFieldValue(FieldValue fieldValue) {
        this.fieldValue = fieldValue;
    }

    Tile(FieldValue fieldValue, Ai aiAlgorithm) {
        this.fieldValue = fieldValue;
        this.aiAlgorithm = aiAlgorithm;

        Rectangle rectangle = new Rectangle(); //siatka
        rectangle.setHeight(200);
        rectangle.setWidth(200);
        rectangle.setFill(null);
        rectangle.setStroke(Color.GREEN);

        setAlignment(Pos.TOP_CENTER);
        getChildren().addAll(rectangle);

        if (getFieldValue() == FieldValue.EMPTY) {
            rectangle.setFill(null);
        }

        setOnMouseClicked(action -> {
            if (!TicTacToe.possibleMove) {
                return;
            }
            if (TicTacToe.vsComputer) {
                if (action.getButton() == MouseButton.SECONDARY) {
                    return;
                }
                if (action.getButton() == MouseButton.PRIMARY) {
                    if (!TicTacToe.turnX || getFieldValue() == FieldValue.CIRCLE || getFieldValue() == FieldValue.CROSS) {
                        return;
                    }
                    setFieldValue(FieldValue.CROSS);
                    rectangle.setFill(new ImagePattern(cross));
                    TicTacToe.turnX = false;
                    checkState();
                    if (!TicTacToe.possibleMove) {
                        return;
                    }
                }

                LogicBoardConverter boardToLogicBoardConverter = new LogicBoardConverter();
                BoardIndex boardIndex = this.aiAlgorithm.calculateMove(boardToLogicBoardConverter.convert
                        (TicTacToe.board, FieldValue.CROSS), Player.COMPUTER);

                Tile tile = TicTacToe.board.fields[boardIndex.getI()][boardIndex.getJ()];
                Rectangle node = (Rectangle) tile.getChildren().get(0);
                tile.setFieldValue(FieldValue.CIRCLE);
                node.setFill(new ImagePattern(circle));
                TicTacToe.turnX = true;
                checkState();
            }

            if (!TicTacToe.vsComputer) {
                if (action.getButton() == MouseButton.PRIMARY) {
                    if (!TicTacToe.turnX || getFieldValue() == FieldValue.CIRCLE || getFieldValue() == FieldValue.CROSS) {
                        return;
                    }
                    setFieldValue(FieldValue.CROSS);
                    rectangle.setFill(new ImagePattern(cross));
                    TicTacToe.turnX = false;
                    checkState();
                }
                if (action.getButton() == MouseButton.SECONDARY) {
                    if (TicTacToe.turnX || getFieldValue() == FieldValue.CROSS || getFieldValue() == FieldValue.CIRCLE) {
                        return;
                    }
                    setFieldValue(FieldValue.CIRCLE);
                    rectangle.setFill(new ImagePattern(circle));
                    TicTacToe.turnX = true;
                    checkState();
                }
            }
        });
    }

    public void checkState() {
        Score score = State.gameResult();
        System.out.println(score);
        if (score == Score.O_WIN) {
            TicTacToe.playerO.setCount(TicTacToe.playerO.getCount() + 1);
            TicTacToe.counter.setText("X  " + TicTacToe.playerX.getCount()
                    + ":" + TicTacToe.playerO.getCount() + " O");
            TicTacToe.possibleMove = false;
            TicTacToe.label.setText("O wins");
            TicTacToe.label.setTextFill(Color.BLACK);
            return;
        }
        if (score == Score.X_WIN) {
            TicTacToe.playerX.setCount(TicTacToe.playerX.getCount() + 1);
            TicTacToe.counter.setText("X  " + TicTacToe.playerX.getCount()
                    + ":" + TicTacToe.playerO.getCount() + "  O");
            TicTacToe.possibleMove = false;
            TicTacToe.label.setText("X wins");
            TicTacToe.label.setTextFill(Color.BLACK);
            return;
        }
        if (score == Score.DRAW) {
            TicTacToe.possibleMove = false;
            TicTacToe.label.setText("draw");
            TicTacToe.label.setTextFill(Color.BLACK);
            return;
        }
        if (score == Score.IN_PROGRESS) {
            if (TicTacToe.turnX) {
                TicTacToe.label.setText("X turn");
                TicTacToe.label.setTextFill(Color.BLACK);
            }
            if (!TicTacToe.turnX) {
                TicTacToe.label.setText("O turn");
                TicTacToe.label.setTextFill(Color.BLACK);
            }
        }
    }
}