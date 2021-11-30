package com.example.battleships.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Game {
    private GameBoard gameBoard = new GameBoard();
    private int[][] gamePlay  = gameBoard.createNewGameBoard();

    public boolean isShipHited(int x, int y) {
        return true;
    }

    private boolean isShipSunken (int shipNumber) {
        return true;
    }

    private boolean isGameOver() {
        return true;
    }






}
