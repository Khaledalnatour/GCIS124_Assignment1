package peggame;

import java.io.IOException;
import java.util.Scanner;
// Main class for running PEg game project
public class Project1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file Path: ");
        String filename = scanner.nextLine().trim();
        //String filename = "C:/Users/hasan/OneDrive/Desktop/peggame/pegGame.txt";
        try {
            //Read Peg game from file
            PegGame pegGame = PegGameFileReader.readFromFile(filename);
            // Display initail board configuration
            System.out.println("Initial Board:");
            System.out.println(pegGame.toString());
            // start playing the peg game 
            CommandLineInterface.playPegGame(pegGame);
        } catch (IOException e) {
            //handle file reading error
            System.err.println("Error reading file: " + e.getMessage());
        }
        scanner.close();
        
    }
}
