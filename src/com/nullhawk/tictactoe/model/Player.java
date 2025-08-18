package com.nullhawk.tictactoe.model;

/**
 * Interface representing a player in the Tic Tac Toe game
 */
public interface Player {
    /**
     * Get the player's symbol (X or O)
     * @return the player's symbol
     */
    String getSymbol();
    
    /**
     * Get the player's name
     * @return the player's name
     */
    String getName();
    
    /**
     * Make a move on the board
     * @param board the current game board
     * @return true if move was successful, false otherwise
     */
    boolean makeMove(Board board);
}
