package com.dariuszsurmacz.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private Button[][] board;  //dwuwymiarowa tablica przyciskow
    private Label textX;
    private Label textO;
    private int xCounter = 0;
    private int oCounter = 0;
    private String[] symbol = {"X", "O"};
    private int player = 0;
    private int counter = 0;
    //?

    public Button[][] getBoard() {
        return board;
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        board = new Button[3][3]; //tablica przycisków 3x3

        int c = 10;
        int r = 10;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < getBoard().length; column++) {
                getBoard()[row][column] = new Button("");
                getBoard()[row][column].setPrefSize(100, 100);
                //utworzenie tablicy przycisków 3x3 z "pustymi" opisami
                gridPane.add(getBoard()[row][column], row + r, column + c);
                gridPane.setHgap(0); //odstępy między przyciskami tablicy; w przyszłości odstępy -> tło kratka
                gridPane.setVgap(0);
            }
        }


        Label roundsCounter = new Label("Wins:");
        gridPane.add(roundsCounter, 1, 0);

        textX = new Label("X wins: 0");
        gridPane.add(textX, 1, 1);

        textO = new Label("O wins: 0");
        gridPane.add(textO, 1, 2);

//button
        Button buttonNewGame = new Button("New\nGame");
        gridPane.add(buttonNewGame, r + 1, c + 4);

        // stworzenie sceny
        Scene scene = new Scene(gridPane, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic-Tac-Toe (Xs and Os)");
        primaryStage.show();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int finalI = i;
                int finalJ = j;
                getBoard()[i][j].setOnAction(action -> {
                            pushTheButton(finalI, finalJ);
                        }
                );
            }
        } //?

        buttonNewGame.setOnAction(action -> {
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    getBoard()[row][column].setText("");
                    getBoard()[row][column].setDisable(false); //wyłącza blokadę przycisków
                }
            }

            player = 0;
            textX.setText("X wins: " + xCounter);
            textO.setText("O wins: " + oCounter);
            counter = 0;
        });

    }


    public void pushTheButton(int i, int j) {
        if (!board[i][j].isDisable()) {  //jesli przycisk jest dostepny
            board[i][j].setText(symbol[player]);
            board[i][j].setDisable(true);
            checkWinnigStatus();
            player = (player + 1) % 2;
            counter++;
        }
        // computer move
        if (player == 1 && counter < 10) {
            Random generator = new Random();
            //?
            int randomComputerI = generator.nextInt(3);  //?
            int randomComputerJ = generator.nextInt(3); //?
            pushTheButton(randomComputerI, randomComputerJ);
        }
    }


    public void checkWinnigStatus() {
        if (board[0][0].getText().equals(symbol[player]) && board[1][1].getText().equals(symbol[player])
                && board[2][2].getText().equals(symbol[player])) {
            if (board[0][0].getText().equals("X")) {
                textX.setText("X wins: " + ++xCounter);
            } else if (board[0][0].getText().equals("O")) {
                textO.setText("O wins: " + ++oCounter);
            }
            alert();

        } else if (board[0][0].getText().equals(symbol[player]) && board[0][1].getText().equals(symbol[player]) &&
                board[0][2].getText().equals(symbol[player])) {
            if (board[0][0].getText().equals("X")) {
                textX.setText("X wins: " + ++xCounter);
            } else if (board[0][0].getText().equals("O")) {
                textO.setText("O wins: " + ++oCounter);
            }
            alert();

        } else if (board[1][0].getText().equals(symbol[player]) && board[1][1].getText().equals(symbol[player]) &&
                board[1][2].getText().equals(symbol[player])) {
            if (board[1][0].getText().equals("X")) {
                textX.setText("X wins: " + ++xCounter);
            } else if (board[1][0].getText().equals("O")) {
                textO.setText("O wins: " + ++oCounter);
            }
            alert();

        } else if (board[2][0].getText().equals(symbol[player]) && board[2][1].getText().equals(symbol[player]) &&
                board[2][2].getText().equals(symbol[player])) {
            if (board[2][0].getText().equals("X")) {
                textX.setText("X wins: " + ++xCounter);
            } else if (board[2][0].getText().equals("O")) {
                textO.setText("O wins: " + ++oCounter);
            }
            alert();

        } else if (board[0][0].getText().equals(symbol[player]) && board[1][0].getText().equals(symbol[player]) &&
                board[2][0].getText().equals(symbol[player])) {
            if (board[0][0].getText().equals("X")) {
                textX.setText("X wins: " + ++xCounter);
            } else if (board[0][0].getText().equals("O")) {
                textO.setText("O wins: " + ++oCounter);
            }
            alert();

        } else if (board[0][1].getText().equals(symbol[player]) && board[1][1].getText().equals(symbol[player]) &&
                board[2][1].getText().equals(symbol[player])) {
            if (board[1][1].getText().equals("X")) {
                textX.setText("X wins: " + ++xCounter);
            } else if (board[1][1].getText().equals("O")) {
                textO.setText("O wins: " + ++oCounter);
            }
            alert();

        } else if (board[0][2].getText().equals(symbol[player]) && board[1][2].getText().equals(symbol[player]) &&
                board[2][2].getText().equals(symbol[player])) {
            if (board[1][1].getText().equals("X")) {
                textX.setText("X wins: " + ++xCounter);
            } else if (board[0][2].getText().equals("O")) {
                textO.setText("O wins: " + ++oCounter);
            }
            alert();

        } else if (board[0][2].getText().equals(symbol[player]) && board[1][1].getText().equals(symbol[player]) &&
                board[2][0].getText().equals(symbol[player])) {
            if (board[2][0].getText().equals("X")) {
                textX.setText("X wins: " + ++xCounter);
            } else if (board[2][0].getText().equals("O")) {
                textO.setText("O wins: " + ++oCounter);
            }
            alert();
//        } else if //wszystkie klawisze niedostępne
//            alertDraw()
        }
    }

    public void alert() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setDisable(true);
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Congratulations");
        alert.setHeaderText(null);
        alert.setContentText(symbol[player] + " wins"); //?
        alert.showAndWait();
    }

    public void alertDraw() {
        Alert alertDraw = new Alert(Alert.AlertType.INFORMATION);
        alertDraw.setTitle("Draw");
        alertDraw.setHeaderText(null);
        alertDraw.setContentText("Draw");
        alertDraw.showAndWait();
    }

}