package com.nullhawk.tictactoe.view;

import com.nullhawk.tictactoe.model.Board;
import com.nullhawk.tictactoe.model.Player;

/**
 * Interface for game view implementations
 */
public interface GameView {
    /**
     * Display the current game board
     * @param board the current game board
     */
    void displayBoard(Board board);
    
    /**
     * Display a message to the user
     * @param message the message to display
     */
    void displayMessage(String message);
    
    /**
     * Get the next move from the current player
     * @param player the current player
     * @return the position where the player wants to move (1-9)
     */
    int getPlayerMove(Player player);
    
    /**
     * Display the winner of the game
     * @param winner the winning player, or null if it's a draw
     */
    void displayWinner(Player winner);
    
    /**
     * Ask if the player wants to play again
     * @return true if player wants to play again, false otherwise
     */
    boolean askPlayAgain();
}
