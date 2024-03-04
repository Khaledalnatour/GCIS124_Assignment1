package peggame;
// Class representing a move in the Peg Game
public class Move {
    private Location from; // Starting location of the move
    private Location to; // Destination location of the move
    // Constructor to initialize the move with from and to locations
    public Move(Location from, Location to) {
        this.from = from;
        this.to = to;
    }
    // Getter method for retrieving the  starting location of the move
    public Location getFrom() {return from;}
    // Getter method for retrieving the destination location of the move
    public Location getTo() {return to;}
}
