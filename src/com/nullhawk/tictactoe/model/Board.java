package com.nullhawk.tictactoe.model;

/**
 * Represents the Tic Tac Toe game board
 */
public class Board {
    private static final int SIZE = 3;
    private String[][] board;
    private int movesCount;
    
    public Board() {
        board = new String[SIZE][SIZE];
        movesCount = 0;
        initializeBoard();
    }
    
    /**
     * Initialize the board with empty positions
     */
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = " ";
            }
        }
    }
    
    /**
     * Check if a move is valid at the given position
     * @param row row index
     * @param col column index
     * @return true if the move is valid, false otherwise
     */
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && 
               board[row][col].equals(" ");
    }
    
    /**
     * Make a move on the board
     * @param row row index
     * @param col column index
     * @param symbol player symbol (X or O)
     */
    public void makeMove(int row, int col, String symbol) {
        if (isValidMove(row, col)) {
            board[row][col] = symbol;
            movesCount++;
        }
    }
    
    /**
     * Check if the board is full (draw)
     * @return true if board is full, false otherwise
     */
    public boolean isFull() {
        return movesCount == SIZE * SIZE;
    }
    
    /**
     * Check if there's a winner
     * @return the winning symbol, or null if no winner
     */
    public String getWinner() {
        // Check rows
        for (int i = 0; i < SIZE; i++) {
            if (!board[i][0].equals(" ") && 
                board[i][0].equals(board[i][1]) && 
                board[i][1].equals(board[i][2])) {
                return board[i][0];
            }
        }
        
        // Check columns
        for (int j = 0; j < SIZE; j++) {
            if (!board[0][j].equals(" ") && 
                board[0][j].equals(board[1][j]) && 
                board[1][j].equals(board[2][j])) {
                return board[0][j];
            }
        }
        
        // Check diagonals
        if (!board[0][0].equals(" ") && 
            board[0][0].equals(board[1][1]) && 
            board[1][1].equals(board[2][2])) {
            return board[0][0];
        }
        
        if (!board[0][2].equals(" ") && 
            board[0][2].equals(board[1][1]) && 
            board[1][1].equals(board[2][0])) {
            return board[0][2];
        }
        
        return null;
    }
    
    /**
     * Display the current board state
     */
    public void displayBoard() {
        System.out.println("\nBoard:");
        System.out.println("-------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].equals(" ")) {
                    System.out.print((i * 3 + j + 1) + " | ");
                } else {
                    System.out.print(board[i][j] + " | ");
                }
            }
            System.out.println();
            System.out.println("-------------");
        }
        System.out.println();
    }
    
    /**
     * Reset the board for a new game
     */
    public void reset() {
        initializeBoard();
        movesCount = 0;
    }
    
    /**
     * Get the current board state
     * @return the board array
     */
    public String[][] getBoard() {
        return board;
    }
    
    /**
     * Get the number of moves made
     * @return the moves count
     */
    public int getMovesCount() {
        return movesCount;
    }
}