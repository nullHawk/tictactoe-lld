package com.nullhawk.tictactoe.service;

import com.nullhawk.tictactoe.model.*;
import com.nullhawk.tictactoe.view.*;

/**
 * Factory class for creating game components
 */
public class GameFactory {
    
    /**
     * Create a new Tic Tac Toe game with human players
     * @param player1Name name of player 1
     * @param player2Name name of player 2
     * @return a configured Game instance
     */
    public static Game createHumanVsHumanGame(String player1Name, String player2Name) {
        Player player1 = new HumanPlayer(player1Name, "X");
        Player player2 = new HumanPlayer(player2Name, "O");
        GameView view = new CLIGameView();
        
        return new Game(player1, player2, view);
    }
    
    /**
     * Create a new Tic Tac Toe game with default player names
     * @return a configured Game instance
     */
    public static Game createDefaultGame() {
        return createHumanVsHumanGame("Player 1", "Player 2");
    }
    
    /**
     * Create a new board
     * @return a new Board instance
     */
    public static Board createBoard() {
        return new Board();
    }
    
    /**
     * Create a human player
     * @param name player name
     * @param symbol player symbol (X or O)
     * @return a new HumanPlayer instance
     */
    public static Player createHumanPlayer(String name, String symbol) {
        return new HumanPlayer(name, symbol);
    }
}
