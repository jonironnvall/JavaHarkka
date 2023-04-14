import java.util.*;
class sudokuBase {
    public static int askDifficulty(){   /** This method asks the user for game difficulty and returns an int according to their choice */

        int sudokuSize=0;

        System.out.println("Choose a difficulty Beginner/Casual/Advanced");    
        Scanner sc=new Scanner(System.in);
        String difficulty=sc.nextLine();                                          /** Scanning user input from scanner */

        if (difficulty.equalsIgnoreCase("beginner")){
            sudokuSize=4;                                                         /** Setting grid size */
        } 
        else if (difficulty.equalsIgnoreCase("casual")){
            sudokuSize=9;                                                         /** Setting grid size */
        } 
        else if (difficulty.equalsIgnoreCase("advanced")){
            sudokuSize=16;                                                        /** Setting grid size */
        }
        else {
            System.out.println("You need to write a valid difficulty level");   /** goes to else when user input doesn't match if/if else statements */
        }
        return sudokuSize;                                                        /** Returning size for the generateGrid method */
    }
    public static void generateGrid(int sudokuSize){

        int sudokuGrid [][]=new int [sudokuSize][sudokuSize];                    /** Making sudoku grid according to the return value of askDifficulty */

    }
}
