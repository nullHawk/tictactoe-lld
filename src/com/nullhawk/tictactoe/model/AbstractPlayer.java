package com.nullhawk.tictactoe.model;

import java.util.Scanner;

/**
 * Abstract base class for players in the Tic Tac Toe game
 */
public abstract class AbstractPlayer implements Player {
    protected String name;
    protected String symbol;
    protected Scanner scanner;
    
    public AbstractPlayer(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    public String getSymbol() {
        return symbol;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Get the player's move from user input
     * @return the position (1-9) where the player wants to move
     */
    protected int getMoveFromUser() {
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
    
    /**
     * Convert board position (1-9) to row and column indices
     * @param position the position (1-9)
     * @return array with [row, column] indices
     */
    protected int[] positionToIndices(int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        return new int[]{row, col};
    }
}
