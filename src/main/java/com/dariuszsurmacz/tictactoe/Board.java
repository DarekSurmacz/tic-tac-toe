package com.dariuszsurmacz.tictactoe;

import javafx.scene.control.Button;

public class Board {
//na razie board jest w klasie main
    private Button[][] board = new Button[3][3];

    public Board(Button[][] board) {
        this.board = board;
    }


    public Button[][] getBoard() {
        return board;
    }
}