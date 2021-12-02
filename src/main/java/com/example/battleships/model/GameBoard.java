package com.example.battleships.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class GameBoard {
    private final int ROWS = 10;
    private final int COLUMNS = 10;
    private final int NUMBER_OF_SHIPS = 3;
    private int[][] gameBoard = new int[ROWS][COLUMNS];


    public int[][] createNewGameBoard() {
        locateShip(AreaStatus.FIRST_SHIP.value, 4);
        locateShip(AreaStatus.SECOND_SHIP.value, 4);
        locateShip(AreaStatus.THIRD_SHIP.value, 5);
        return gameBoard;
    }

    private void  locateShip(int shipNumber, int shipLength) {
        Random random = new Random();
        int x;
        int y;
        boolean isVertical ;
        do {
            isVertical = random.nextBoolean();
            if (isVertical) {
                x = random.nextInt(COLUMNS - shipLength);
                y = random.nextInt(ROWS);
            } else {
                x = random.nextInt(COLUMNS);
                y = random.nextInt(ROWS - shipLength);
            }
        } while (!checkFreeSpace(x, y, isVertical, shipLength));

        addShipToBoard(x, y, isVertical, shipNumber, shipLength);
    }

    private void addShipToBoard(int x, int y, boolean isVertical, int shipNumber, int shipLenghth) {
        if (isVertical) {
            for (int i = 0; i < shipLenghth; i++) {
                gameBoard[x][y] = shipNumber;
                x++;
            }
        } else {
            for (int i = 0; i < shipLenghth; i++) {
                gameBoard[x][y] = shipNumber;
                y++;
            }
        }
    }

    private boolean checkFreeSpace (int x, int y, boolean isVertical, int shipLenghth) {
        if (isVertical) {
            for (int i = 0; i < shipLenghth; i++) {
                if (gameBoard[x][y] != 0) return  false;
                x++;
            }
        } else {
            for (int i = 0; i < shipLenghth; i++) {
                if (gameBoard[x][y] != 0) return  false;
                y++;
            }
        }
        return true;
    }
}
