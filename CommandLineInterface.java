package peggame;
import java.util.Scanner;

public class CommandLineInterface {
    //Method to start playing the game
     public static void playPegGame(PegGame pegGame) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Peg Game! Enter your commands:");
        // accepts user commands until quit or game ends
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            // checks if user wants to quit
            if (input.equals("quit")) {
                System.out.println("Goodbye!");
                break;
            } else {
                // proccess the user's command 
                processCommand(input, pegGame);
                // check if the game has been won 
                if (pegGame.getGameState() == GameState.WON) {
                    System.out.println("Congratulations! You have won the game!");
                    break;
                } else if (pegGame.getGameState() == GameState.STALEMATE) {
                    System.out.println("The game ended in a stalemate.");
                    break;
                }
            }
        }
        scanner.close();
    }
    // Method to process the user comand
    private static void processCommand(String input, PegGame pegGame) {
        String[] value = input.split("\\s+");
        //check if the command is to make a move
        if ("move".equals(value[0]) && value.length == 5) {
            try {
                //parse the coordinates for the move
                int r1 = Integer.parseInt(value[1]);
                int c1 = Integer.parseInt(value[2]);
                int r2 = Integer.parseInt(value[3]);
                int c2 = Integer.parseInt(value[4]);
                //create a move object with the parsed coordinates
                Location from = new Location(r1, c1);
                Location to = new Location(r2, c2);
                Move move = new Move(from, to);
                //attempt to make the move
                pegGame.makeMove(move);
                System.out.println("Move successful.");
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | PegGameException e) {
                //handle exceptions for invalid moves
                System.err.println("Invalid move: " + e.getMessage());
            }
        } else if ("quit".equals(value[0]) && value.length == 2) {
            // check if the command is to quit the game 
            System.out.println("Goodbye!");
            //Terminate the program
            System.exit(0);
        } else {
            //Notify user of an invalid command format
            System.err.println("Invalid command. Please use the format 'move r1 c1 r2 c2' or 'quit'.");
        }
    }
}
