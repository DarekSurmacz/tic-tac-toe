package com.dariuszsurmacz.tictactoe.logic;

public interface Ai {
    BoardIndex calculateMove(LogicBoard logicBoard, Player player);
}