package peggame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Class for reading Peg Game configuration from a file
public class PegGameFileReader {
    //Method to read peg game from  a file
    public static PegGame readFromFile(String filename) throws IOException {
        //Create a bufferred reader to read from the file
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        // Read the number of rows in the board
        int rows = Integer.parseInt(reader.readLine());
        // Create a 2D char array to represent the board
        char[][] board = new char[rows][rows];
        // Populate the board with peg positions
        for (int i = 0; i < rows; i++) {
            String line = reader.readLine();
            for (int j = 0; j < rows; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        //Create a SquarePegGame instance with the specified rows and initial peg configuration
        SquarePegGame pegGame = new SquarePegGame(rows, new char[rows*rows], GameState.NOT_STARTED);
        // set the board for the peg game
        pegGame.setBoard(board);
        // Read the game state from the file and update the Peg Game accordingly
        String line;
        while ((line = reader.readLine()) != null) {
            String trimmedLine = line.trim();
            if ("NOT_STARTED".equals(trimmedLine)) {
                pegGame.setGameState(GameState.NOT_STARTED);
            } else if ("IN_PROGRESS".equals(trimmedLine)) {
                pegGame.setGameState(GameState.IN_PROGRESS);
            } else if ("STALEMATE".equals(trimmedLine)) {
                pegGame.setGameState(GameState.STALEMATE);
            } else if ("WON".equals(trimmedLine)) {
                pegGame.setGameState(GameState.WON);
            }
        }
        //Close the reader
        reader.close();
        //Return the peg game
        return pegGame;
    }
}
