package com.nullhawk.tictactoe.model;

import com.nullhawk.tictactoe.view.GameView;

/**
 * Main game class that manages the Tic Tac Toe game
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameView view;
    private boolean gameOver;
    
    public Game(Player player1, Player player2, GameView view) {
        this.player1 = player1;
        this.player2 = player2;
        this.view = view;
        this.board = new Board();
        this.currentPlayer = player1;
        this.gameOver = false;
    }
    
    /**
     * Start the game
     */
    public void start() {
        view.displayMessage("Welcome to Tic Tac Toe!");
        view.displayMessage("Player 1: " + player1.getName() + " (" + player1.getSymbol() + ")");
        view.displayMessage("Player 2: " + player2.getName() + " (" + player2.getSymbol() + ")");
        
        do {
            playGame();
        } while (view.askPlayAgain());
        
        view.displayMessage("Thanks for playing!");
    }
    
    /**
     * Play a single game
     */
    private void playGame() {
        board.reset();
        gameOver = false;
        currentPlayer = player1;
        
        while (!gameOver) {
            view.displayBoard(board);
            
            // Get current player's move
            int position = view.getPlayerMove(currentPlayer);
            int[] indices = convertPositionToIndices(position);
            int row = indices[0];
            int col = indices[1];
            
            if (board.isValidMove(row, col)) {
                board.makeMove(row, col, currentPlayer.getSymbol());
                
                // Check for winner
                String winnerSymbol = board.getWinner();
                if (winnerSymbol != null) {
                    view.displayBoard(board);
                    view.displayWinner(currentPlayer);
                    gameOver = true;
                } else if (board.isFull()) {
                    view.displayBoard(board);
                    view.displayWinner(null); // Draw
                    gameOver = true;
                } else {
                    // Switch players
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } else {
                view.displayMessage("Invalid move! Position " + position + " is already taken.");
            }
        }
    }
    
    /**
     * Convert position (1-9) to row and column indices
     * @param position the position (1-9)
     * @return array with [row, column] indices
     */
    private int[] convertPositionToIndices(int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        return new int[]{row, col};
    }
    
    /**
     * Get the current board
     * @return the game board
     */
    public Board getBoard() {
        return board;
    }
    
    /**
     * Get the current player
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    /**
     * Check if the game is over
     * @return true if game is over, false otherwise
     */
    public boolean isGameOver() {
        return gameOver;
    }
}
