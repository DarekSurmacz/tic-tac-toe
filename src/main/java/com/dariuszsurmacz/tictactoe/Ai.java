package com.dariuszsurmacz.tictactoe;

public interface Ai {
    BoardIndex calculateMove(LogicBoard logicBoard, Player player);
}