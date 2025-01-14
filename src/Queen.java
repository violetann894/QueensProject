/**
 *  The queen class is used to solve the 8 queens problem. The 8 queens problem is where 8 queens
 *  must be placed on a 8x8 chess board in such a way that the queens will not be threatening any of the
 *  other queens on the board.
 * @author violetann894
 */
public class Queen {
    /**
     * This variable holds the x (column) position of the queen
     */
    private final int x;
    /**
     * This variable holds the y (row) position of the queen
     */
    private final int y;
    /**
     * This 2d array variable holds the board that the queens will be placing themselves on.
     * It is a 8x8 board that is initialized with "-" as black spaces. This variable is static
     * as all instances of the queen class will need access to this variable.
     */
    public static String[][] board = {{"-","-","-","-","-","-","-","-"},
                                      {"-","-","-","-","-","-","-","-"},
                                      {"-","-","-","-","-","-","-","-"},
                                      {"-","-","-","-","-","-","-","-"},
                                      {"-","-","-","-","-","-","-","-"},
                                      {"-","-","-","-","-","-","-","-"},
                                      {"-","-","-","-","-","-","-","-"},
                                      {"-","-","-","-","-","-","-","-"}};
    /**
     * This static variable holds the total number of queens that have been created. 8 are needed
     * to be able to successfully use the program.
     */
    public static int numberOfQueens;

    /**
     * Constructor for the class Queen. Initializes the instance variables x and y given
     * the parameters that  it has been given. Then adds one to the static variable numberOfQueens
     * to keep track of how many have been created. It then calls the method placeXs() to place "X"s where
     * the queen could attack on the board.
     * @param x The x (column) position the queen will have in the 2D array
     * @param y The y (row) position the queen will have in the 2D array
     * @see #numberOfQueens
     * @see #placeXs()
     */
    public Queen (int x, int y){
        this.x = x;
        this.y = y;
        numberOfQueens++;
        this.checkPlacement();
    }

    /**
     * This method checks to see if the position given to the Queen object is safe. If it is safe,
     * it places the queen ("Q") in her place and then calls the placeXs() method to place down where
     * she could threaten other queens.
     * @see #placeXs()
     */
    public void checkPlacement(){
         /*This statement checks if the value of the spot the
         queen would be going into is a valid space or not
         */
        if(!board[y][x].equals("X")){
            board[this.y][this.x] = "Q";
            this.placeXs();
        }else {
            System.out.println("This configuration is not valid.");
            /*The purpose of the exit statements is to prevent the program
            from taking in the previous attempt's queens. By exiting, the
            program has to start anew, which should prevent the problem */
            System.exit(0);
        }
    }

    /**
     * This method places "X"s on the 2d array board in a horizontal, a vertical and diagonal lines
     * where the queen could attack.
     * @see #y
     * @see #x
     * @see #board
     */
    public void placeXs(){ 
        //Then the method will add X's to all the places where the queen could move to
        for(int i = 0; i < 8; i++){
            if(!board[this.y][i].equals("Q")) {
                //Vertical addition of Xs everywhere but the "Q"
                board[this.y][i] = "X";
            }
        }
        for(int j = 0; j < 8; j++){
            if(!board[j][this.x].equals("Q")){
                //Horizontal addition of Xs everywhere but the "Q"
                board[j][this.x] = "X";
            }
        }
        int tempX = this.x;
        int tempY = this.y;
        //Diagonal placement of Xs right and down
        while(tempX < 7 && tempY < 7){
            board[tempY+1][tempX+1] = "X";
            tempY++;
            tempX++;
        }
        tempY = this.y;
        tempX = this.x;
        //Diagonal placement of Xs left and up
        while(tempX > 1 && tempY > 1){
            board[tempY-1][tempX-1] = "X";
            tempY--;
            tempX--;
        }
        tempY = this.y;
        tempX = this.x;
        //Diagonal placement of Xs right and up
        while(tempX < 7 && tempY > 1){
            board[tempY-1][tempX+1] = "X";
            tempY--;
            tempX++;
        }
        tempY = this.y;
        tempX = this.x;
        //Diagonal placement of Xs left and down
        while(tempX > 1 && tempY < 7){
            board[tempY+1][tempX-1] = "X";
            tempY++;
            tempX--;
        }
    }

    /**
     * This method is used to take in a string of positions for the Queen objects. By using substrings
     * the method is able to separate the different digits of the string, convert them to ints and then
     * pass the number and its position to the Queen constructor. If the parameter string holds a string that has
     * characters that hold no value, then an exception is thrown and the method tells the user that the value within
     * the variable is not valid. After the whole string has been iterated through, the method calls printOutBoard()
     * to print out the 2d array if the operation has been successful. The program then exits.
     * @param queenPlacement user inputted string that contains 8 numbers which is used for the x and y position for
     *                       each queen object.
     * @see #printOutBoard()
     */
    public static void separateQueens(String queenPlacement){
        try{
            //This for loop iterates through the string
            for(int i = 0; i < queenPlacement.length(); i++){
                /*The variable holds the value of the String converted into an integer, minus 1.
                Subtracting by one makes sure that the values fall within the correct
                range of the 2d array. */
                int firstNum = (Integer.parseInt(queenPlacement.substring(i, i+1))-1);
                /*The variable holding the queen is not needed, as we just need it to instantiate the queen
                to place down its "Q" and its "X"s */
                Queen x = new Queen(i,firstNum);
            }
            System.out.println("Success! Here is the board:");
            Queen.printOutBoard();
            System.exit(0);

        /*The purpose of this catch statement is to check if the user types in a string that does
        not hold a value of any kind. For example: "123Hello45678" */
        }catch (Exception e){
            System.out.println("That is not a valid input");
            /*The purpose of the exit statements is to prevent the program
            from taking in the previous attempt's queens. By exiting, the
            program has to start anew, which should prevent the problem */
            System.exit(0);
        }

    }

    /**
     * This method first checks numberOfQueens to make sure that 8 queens have been created.
     * If not the program exits.The method then iterates through the 2d array board to display
     * where all the queens have been placed and where the queens have threatening positions("X").
     * @see #board
     * @see #numberOfQueens
     */
    public static void printOutBoard() {
        //Checking to make sure the correct number of queen are present (Should be 8)
        if (numberOfQueens == 8) {
            //For each statement running through the rows of the 2d array
            for (String[] temp : board) {
                //For each statement running through the columns of the 2d array
                for (String y : temp) {
                    System.out.print(y + ", ");
                }
                System.out.println();
            }
            System.out.println();
        } else {
            System.out.println("Incorrect number of queens");
            /*The purpose of the exit statements is to prevent the program
            from taking in the previous attempt's queens. By exiting, the
            program has to start anew, which should prevent the problem */
            System.exit(0);
        }
    }
}

