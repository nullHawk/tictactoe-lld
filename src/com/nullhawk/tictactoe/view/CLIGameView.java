package com.nullhawk.tictactoe.view;

import com.nullhawk.tictactoe.model.Board;
import com.nullhawk.tictactoe.model.Player;
import java.util.Scanner;

/**
 * Command Line Interface implementation of GameView
 */
public class CLIGameView implements GameView {
    private Scanner scanner;
    
    public CLIGameView() {
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    public void displayBoard(Board board) {
        board.displayBoard();
    }
    
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    @Override
    public int getPlayerMove(Player player) {
        System.out.println("\n" + player.getName() + "'s turn (" + player.getSymbol() + ")");
        
        while (true) {
            try {
                System.out.print("Enter your move (1-9): ");
                int move = Integer.parseInt(scanner.nextLine().trim());
                if (move >= 1 && move <= 9) {
                    return move;
                } else {
                    System.out.println("Please enter a number between 1 and 9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
    @Override
    public void displayWinner(Player winner) {
        if (winner != null) {
            System.out.println("\n🎉 Congratulations! " + winner.getName() + " (" + winner.getSymbol() + ") wins! 🎉");
        } else {
            System.out.println("\n🤝 It's a draw! 🤝");
        }
    }
    
    @Override
    public boolean askPlayAgain() {
        while (true) {
            System.out.print("\nWould you like to play again? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            
            if (response.equals("y") || response.equals("yes")) {
                return true;
            } else if (response.equals("n") || response.equals("no")) {
                return false;
            } else {
                System.out.println("Please enter 'y' for yes or 'n' for no.");
            }
        }
    }
}
