package com.example.battleships.model;

public enum AreaStatus {
    FIRST_SHIP (1),
    SECOND_SHIP(2),
    THIRD_SHIP(3),
    MISS (10),
    HITED (100);

    final int value;

     AreaStatus(int areaValue) {
        value = areaValue;
    }
}
