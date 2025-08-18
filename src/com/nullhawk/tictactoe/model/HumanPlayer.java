package com.nullhawk.tictactoe.model;

/**
 * Human player implementation for the Tic Tac Toe game
 */
public class HumanPlayer extends AbstractPlayer {
    
    public HumanPlayer(String name, String symbol) {
        super(name, symbol);
    }
    
    @Override
    public boolean makeMove(Board board) {
        System.out.println("\n" + getName() + "'s turn (" + getSymbol() + ")");
        board.displayBoard();
        
        while (true) {
            int position = getMoveFromUser();
            int[] indices = positionToIndices(position);
            int row = indices[0];
            int col = indices[1];
            
            if (board.isValidMove(row, col)) {
                board.makeMove(row, col, getSymbol());
                return true;
            } else {
                System.out.println("That position is already taken. Please choose another position.");
            }
        }
    }
}
