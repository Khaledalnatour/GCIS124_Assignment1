package peggame;

import java.util.Collection;
//Interface reresenting a Peg Game
public interface PegGame {
    //Method to get all possible moves in the current game state
    Collection<Move> getPossibleMoves();
    
    //Method to get the current state of the game
    GameState getGameState();

    //Method to make a move in the game
    void makeMove(Move move) throws PegGameException;
    
}
