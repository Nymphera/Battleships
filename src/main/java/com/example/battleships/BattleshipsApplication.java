package com.example.battleships;

import com.example.battleships.model.Game;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BattleshipsApplication implements CommandLineRunner {

    @Override
    public void run(String... args) {
        main(args);
    }

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome");
        do {
            int[][] gameBoarfd = game.getGamePlay();
            for (int i = 0; i < 10; i++) {
                System.out.print("|");
                for (int j = 0; j < 10; j++) {
                    System.out.print(decode(gameBoarfd[i][j]) + " | ");
                }
                System.out.println("");
            }

            System.out.println("Make a shot");
            String coordinates = scanner.nextLine();
            game.checkIfShipIsHited(coordinates);
        } while (!game.isGameEnd());
        System.out.println("You won!!");
//        SpringApplication.run(BattleshipsApplication.class, args);
    }

    private static char decode(int i) {
        if (i == 10) return '*';
        if (i >= 0 && i < 10) return ' ';
        if (i > 100) return 'x';
        return ' ';
    }

}
