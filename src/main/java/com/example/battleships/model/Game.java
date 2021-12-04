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
        gamePlay = gameBoard.createNewGameBoard();
    }

    public String getAreaValue(int x, int y) {
        if (gamePlay[x][y] == 10) {
            return "*";
        } else if (gamePlay[x][y] > 100) {
            return "x";
        } else {
            return "";
        }
    }


    public boolean isShipHitted(int x, int y) {
        System.out.println(gameEnd);
        switch (gamePlay[x][y]) {
            case 0:
                gamePlay[x][y] = AreaStatus.MISS.value;
                communicate = "You miss. Try again :)";
                return false;
            case 1:
                gamePlay[x][y] = AreaStatus.HITTED_FIRST_SHIP.value;
                communicate = "You hit. Congratz :D";
                checkIfShipIsSunken(1);
                return true;
            case 2:
                gamePlay[x][y] = AreaStatus.HITTED_SECOND_SHIP.value;
                communicate = "You hit. Congratz :D";
                checkIfShipIsSunken(2);
                return true;
            case 3:
                gamePlay[x][y] = AreaStatus.HITTED_THIRD_SHIP.value;
                communicate = "You hit. Congratz :D";
                checkIfShipIsSunken(3);
                return true;
            default:
                communicate = "You already shot this place";
        }
        return false;
    }

    private void checkIfShipIsSunken(int shipNumber) {
        System.out.println("im triggered");
        int matching = 0;
        for (int[] row : gamePlay) {
            for (int number : row) {
                if (number == shipNumber) {
                    matching++;
                }
            }
        }
        System.out.println(matching);

        if (matching == 0) {
            communicate = ("Ship destroyed. You're awesome!!");
            System.out.println("if triggered");
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
        System.out.println("gameEnd:" + gameEnd);
        if (matching == 0) {
            gameEnd = true;
            System.out.println("gameEnd:" + gameEnd);
        }
    }
}









