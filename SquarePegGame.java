package peggame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
// Class representing the Square Peg game
public class SquarePegGame implements PegGame {
    private int rows; // Number of rows in the game board
    private char[][] board; // 2D array representing the game board
    private GameState gameState; // Current state of the game
// constructor to initialize the square Peg game
    public SquarePegGame(int rows, char[] board, GameState gameState) {
        this.rows = rows;
        this.board = new char[rows][rows];
        this.gameState = gameState;
    }
    // Setter method to set the game board
    public void setBoard(char[][] board) {this.board = board;}
    // Getter method to get the number of rows in the game board
    public int getRows() { return rows; }

    //Method to get all possible moves in the current game state
   @Override
    public Collection<Move> getPossibleMoves() {
        List<Move> possibleMoves = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (isValidLocation(row, col)) {
                    if (isValidMove(new Location(row, col))) {
                        possibleMoves.add(new Move(new Location(row, col), null));
                    }
                }
            }
        }
        return possibleMoves;
    }
    // Method to check if a location is valid on the board
    private boolean isValidLocation(int row, int col) {return row >= 0 && row < rows && col >= 0 && col < rows;}
    // Placeholder method for checking if a move is valid to be implemented
    private boolean isValidMove(Location location) {return true; }
    // Method to get the current game state
    @Override
    public GameState getGameState() {
        int pegCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (isValidLocation(row, col) && board[row][col] == 'o') {
                    pegCount++;
                }
            }
        }
        if (pegCount == 1) {
            return GameState.WON; 
        } else if (pegCount > 1) {
            return GameState.IN_PROGRESS; 
        } else {
            
            return GameState.STALEMATE; 
        }
    
    }
    // Method to make a move
    @Override
    public void makeMove(Move move) throws PegGameException {
        Location to = move.getTo();
        if (isValidMove(to)) {
            placePeg(to); 
            System.out.println(toString());
        } else {
            throw new PegGameException("Invalid move: " + move);
        }
    }
    // Method to place a peg at the specified location on the board
    public void placePeg(Location location) {
        if (isValidLocation(location.getRow(), location.getCol())) {
            board[location.getRow()][location.getCol()] = '-';
        } else {
            System.err.println("Invalid location: " + location);
        }
    }
    //Method to represent the game board as a string
    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < rows; i++) {
        if (i > 0) {
            sb.append("\n");
        }
        for (int j = 0; j < rows; j++) {
            if (board[i][j] == 0) {
                sb.append('o'); 
            } else {
                sb.append(board[i][j]);
            }
        }
    }
    return sb.toString();
    }
    // setter method to set the game state
    public void setGameState(GameState notStarted) {
        throw new UnsupportedOperationException("Unimplemented method 'setGameState'");
    }
}

