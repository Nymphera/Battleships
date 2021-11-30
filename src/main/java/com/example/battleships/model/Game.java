package com.example.battleships.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Game {
    private GameBoard gameBoard = new GameBoard();
    private int[][] gamePlay  = gameBoard.createNewGameBoard();
    private boolean gameEnd;
    private final int ASCII_CODE_FOR_A = 65;
    private final int ASCII_CODE_FOR_ONE = 49;


    public void checkIfShipIsHited(String coordinates) {
        int x = getXCoordinate(coordinates);
        int y = getYCoordinates(coordinates);
        switch (gamePlay[x][y]) {
            case 0:
                gamePlay[x][y] = AreaStatus.MISS.value;
                System.out.println("You misse. Try again :)");
                break;
            case 1:
                gamePlay[x][y] = AreaStatus.HITTED_FIRST_SHIP.value;
                checkIfShipIsSunken(1);
                System.out.println("You hited. Congratz :D");
                break;
            case 2:
                gamePlay[x][y] = AreaStatus.HITTED_SECOND_SHIP.value;
                checkIfShipIsSunken(2);
                System.out.println("You hited. Congratz :D");
                break;
            case 3:
                gamePlay[x][y] = AreaStatus.HITTED_THIRD_SHIP.value;
                checkIfShipIsSunken(3);
                System.out.println("You hited. Congratz :D");
                break;
            default:
                System.out.println("You already shot this place");
        }
    }

    private int getXCoordinate (String coordinates) {
        return (int) coordinates.charAt(0) - ASCII_CODE_FOR_A;
    }

    private int getYCoordinates (String coordinates) {
        if (coordinates.length() == 2) {
            return (int) coordinates.charAt(1) - ASCII_CODE_FOR_ONE;
        } else {
            return 9;
        }
    }

    private void checkIfShipIsSunken (int shipNumber) {
        boolean anyMatch = false;
        for ( int[] row : gamePlay) {
            for (int number : row) {
                if (number == shipNumber) {
                    anyMatch = true;
                }
            }
        }

        if (!anyMatch) {
            System.out.println("Ship destroyed. You're awsome!!");
            gameEnd =isGameOver();
        }
    }

    private boolean isGameOver() {
        for ( int[] row : gamePlay) {
            for (int number : row) {
                if (number > 0 && number <= gameBoard.getNUMBER_OF_SHIPS())
                    return false;
                }
            }
        System.out.println("Congratulations!! You won the game!");
        return true;
        }
    }







