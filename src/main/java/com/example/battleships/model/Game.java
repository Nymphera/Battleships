package com.example.battleships.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Getter
@Setter
@Component


public class Game {
    private GameBoard gameBoard;
    private int[][] gamePlay;
    private boolean gameEnd = false;
    private String communicate = "";


    public Game(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void startNewGame() {
        this.gameEnd = false;
        gamePlay = gameBoard.createNewGameBoard();
    }

    public String getAreaValue(int x, int y) {
        if (gamePlay[x][y] == 10) {
            return "*";
        } else if (gamePlay[x][y] == 100) {
            return "x";
        } else {
            return "";
        }
    }

    public boolean checkHit(int x, int y) {
        switch (gamePlay[x][y]) {
            case 0:
                gamePlay[x][y] = AreaStatus.MISS.value;
                communicate = "You miss. Try again :)";
                return false;
            case 1:
                gamePlay[x][y] = AreaStatus.HITED.value;
                communicate = "You hit. Congratz :D";
                checkSunk(1);
                return true;
            case 2:
                gamePlay[x][y] = AreaStatus.HITED.value;
                communicate = "You hit. Congratz :D";
                checkSunk(2);
                return true;
            case 3:
                gamePlay[x][y] = AreaStatus.HITED.value;
                communicate = "You hit. Congratz :D";
                checkSunk(3);
                return true;
            default:
                communicate = "You already shot this place";
        }
        return false;
    }

    private void checkSunk(int shipNumber) {
        int matching = 0;
        for (int[] row : gamePlay) {
            for (int number : row) {
                if (number == shipNumber) {
                    matching++;
                }
            }
        }

        if (matching == 0) {
            communicate = ("Ship destroyed. You're awesome!!");
            isGameOver();
        }
    }

    private void isGameOver() {
        int matching = 0;
        for (int[] row : gamePlay) {
            for (int number : row) {
                if (number > 0 && number <= gameBoard.getNUMBER_OF_SHIPS()) {
                    matching++;
                }
            }
        }
        if (matching == 0) {
            gameEnd = true;
        }
    }
}









