package com.dariuszsurmacz.tictactoe.logic;

import com.dariuszsurmacz.tictactoe.BoardIndex;

public interface Ai {
    BoardIndex calculateMove(LogicBoard logicBoard, Player player);
}