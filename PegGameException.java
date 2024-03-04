package peggame;

//Exception class for peg game related exceptions
public class PegGameException extends Exception {
    String message = "invalid move";

    //constructor to create a PegGameException with a custom message
    public PegGameException(String message) {
        super(message);
    }
}
