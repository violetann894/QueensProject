import java.util.Scanner;

/**
 * This class is used to start the Queen class and its methods
 */
public class Main {
    /**
     * The main method used to hold the scanner class and created scanner object for user input.
     * This method also tells the user the information that it would like them to input for the Queen
     * object. The method then takes in console input using the Scanner object userInput and passes it
     * to the Queen class method separateQueens.
     * @see Queen
     * @param args
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please type in the configuration of queens " +
                "(will be read from left to right):");
        Queen.separateQueens(userInput.nextLine());

    }
}
