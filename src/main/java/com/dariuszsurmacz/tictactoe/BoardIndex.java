package com.dariuszsurmacz.tictactoe;

public class BoardIndex {

    int row;
    int column;

    public BoardIndex(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}