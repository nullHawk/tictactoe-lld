package com.nullhawk.tictactoe;

import com.nullhawk.tictactoe.model.Game;
import com.nullhawk.tictactoe.service.GameFactory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== TIC TAC TOE ===");
        System.out.println("Welcome to the game!");
        
        System.out.print("Enter Player 1 name (or press Enter for default): ");
        String player1Name = scanner.nextLine().trim();
        if (player1Name.isEmpty()) {
            player1Name = "Player 1";
        }
        
        System.out.print("Enter Player 2 name (or press Enter for default): ");
        String player2Name = scanner.nextLine().trim();
        if (player2Name.isEmpty()) {
            player2Name = "Player 2";
        }
        
        // Create and start the game
        Game game = GameFactory.createHumanVsHumanGame(player1Name, player2Name);
        game.start();
        
        scanner.close();
    }
}