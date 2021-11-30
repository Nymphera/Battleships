package com.example.battleships.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GameBoard {
    private final int ROWS = 10;
    private final int COLUMNS = 10;
    private int[][] gameBoard = new int[ROWS][COLUMNS];



    public int[][] createNewGameBoard() {
        return gameBoard;
    }

    private void  locateShip(int shipNumber, int shipLength) {

    }

    private boolean checkFreeSpace (int x, int y, boolean isVertival) {

        return true;
    }
}
