package com.example.battleships.model;

public enum AreaStatus {
    EMPTY (0),
    FIRST_SHIP (1),
    SECOND_SHIP(2),
    THIRD_SHIP(3),
    MISS (10),
    HITTED_FIRST_SHIP(101),
    HITTED_SECOND_SHIP(102),
    HITTED_THIRD_SHIP(103);

    final int value;

     AreaStatus(int areaValue) {
        value = areaValue;
    }
}
