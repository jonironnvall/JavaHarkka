package sudokuLogic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import sudokuLogic.coordinates;     /*Coordinates for the solvedGameGeneration.*/
import sudokuLogic.rows;            /*Rows for the checking of squares.*/



public class gameGenerator {


    public static int[][] solvedGameGeneration() {
        Random random = new Random(System.currentTimeMillis());     /* Creating a random number generator */
        int[][] newGrid = new int[9][9];                            /* NOTE: this part is now usable for only 9 x 9 grids, smaller ones are off the table with this */
        
        for (int value = 1; value <= 9; value++){                   /* Outer for loop for making sure dublicate numbers in the same positions wont occur. Tests all positions. */
            int allocations = 0;
            int interrupt = 0;
            int tries = 0;
            List<coordinates> allocTracker = new ArrayList<>(); /* Making an allocation tracker for backtracking if the generation doen't go smoothly (if the puzzle is unsolvable or if it includes zeroes.) */

            tries++;

            while (allocations < 9){                            /* Inner while loop for actually placing the "value" into the sudoku squares*/
                if(interrupt > 200){                            /* If the program doesnt find a suitable number in the position it assign it as 0, so it can try again later. */
                    allocTracker.forEach(coord -> {
                        newGrid[coord.getX()][coord.getY()] = 0;   });
                        
                        allocations = 0;
                        interrupt = 0;
                        allocTracker.clear();                   /*In the case of and invalid puzzle it also clears the allocation tracker as it is backtracking to a prevoius state, which is stored in the allocation tracker. */
                        tries++;                                /*Adds one to the "tries" variable which is used in the following if-loop */
                
                        if (tries > 500) {                      /*When the "tries valuable is more than 500, the program is jammed and cannot find a suitable value for the position even after 500 tries, we delete the whole process and start from the beginning." */
                            nukeCurrentGame(newGrid);
                            tries = 0;
                            value = 1;
                }
            }
            int xCoordinate = random.nextInt(9);        /*Randomly chooses a position to assign the value to  */
            int yCoordinate = random.nextInt(9);

            if(newGrid[xCoordinate][yCoordinate] == 0){     /* Assings the value*/
                newGrid[xCoordinate][yCoordinate] = value;
                
                if(invalidsudoku(newGrid)) {                /* Check if the sudoku is not valid so far without looking at the zeroes in the puzzle. */
                    newGrid[xCoordinate][yCoordinate] = 0;  /*If not it sets the value as 0, meaning its an empty unassigned position and it tries again. */
                    interrupt++;                            /* adds 1 to the interrupt - variable*/
            }
            else {
                allocTracker.add(new coordinates(xCoordinate, yCoordinate));       /* If all goes well it goes into the allocation tracker*/
                allocations++;                                                     /*adds 1 to the allocations -variable */
                }
             }
          }
        }
    
        

    return newGrid;
}

    public static void nukeCurrentGame(int[][] newGrid){                       /* if all goes wrong there has to be an escape to "nuke" the whole program BOOM ; . o*/
        for(int x = 0; x < 9; x++){
            for(int y= 0; y < 9; y++){
                newGrid[x][y]= 0;
            }
        }

    }

    public static boolean checkForCompletion(int[][] newGrid) {             /* This is used later on just before starting the game, where the program checks one last time just before unsolving it if its solvable and fully filled*/
        if (invalidsudoku(newGrid)) return false;
        if (tilesAreNotFilled(newGrid)) return false;
        return true;
    }

public static boolean invalidsudoku(int[][] newGrid){       /* Checking if the sudoku isn't solvable*/
    if(rowsAreInvalid(newGrid)) return true;                /* Checking if the rows of the puzzle arent solvable*/
    if(columnsAreInvalid(newGrid)) return true;             /* Checking if the columns of the puzzle arent solvable*/
    if(squaresAreInvalid(newGrid)) return true;             /* Checking if the squares of the puzzle arent solvable*/
    else return false;


}

public static boolean columnsAreInvalid(int[][] newGrid){   /* Checking if the columns are invalid by checking if the collection has repeating numbers*/
    for (int xIndex = 0; xIndex < 9; xIndex++){
        List<Integer> row = new ArrayList<>();
        for(int yIndex = 0; yIndex <9; yIndex++){
            row.add(newGrid[xIndex][yIndex]);

    }
        if (collectionHasRepeats(row)) return true;         /*  If not return false and go on with the generation*/
}
    return false;
}
public static boolean rowsAreInvalid(int[][] newGrid){      /* Checking if the rows are invalid by checking if the collection has repeating numbers*/
    for (int yIndex = 0; yIndex < 9; yIndex++){
        List<Integer> row = new ArrayList<>();
        for(int xIndex = 0; xIndex <9; xIndex++){
            row.add(newGrid[xIndex][yIndex]);

    }
        if (collectionHasRepeats(row)) return true;
}
    return false;                                           /*  If not return false and go on with the generation*/

}

public static boolean collectionHasRepeats(List<Integer> collection) {     /*Method for checking if row, columns or squares have repeating numbers and calling them collections */
    for (int index = 1; index <= 9; index++) {                              /* For loop which starts from the value of 1, because this way the program doesnt return true, if the collection has repeating zeroes / empty spaces*/
        if (Collections.frequency(collection, index) > 1) return true;     /*We used the .frequency command as it's the fastest way to find frequently appearing numbers */
    }

    return false;
}


public static boolean squaresAreInvalid(int[][] grid) {             /*The 'main' method that checks if the squares of the puzzle are invalid */
    if (rowOfSquaresIsInvalid(rows.TOP, grid)) return true;         /*Includes all rows of squares seperatly*/

    if (rowOfSquaresIsInvalid(rows.MIDDLE, grid)) return true;

    if (rowOfSquaresIsInvalid(rows.BOTTOM, grid)) return true;

    return false;



}

private static boolean rowOfSquaresIsInvalid(rows value, int[][] grid) {    /*A lower method which assings the starting values for the lowest method to check wheter the squares are invalid or not*/
    switch (value) {
        case TOP:
            if (squareIsInvalid(0, 0, grid)) return true;   /*For example the first square starts from the coordinates [0][0] and uses this as a starting point in the following method.*/
            if (squareIsInvalid(0, 3, grid)) return true;
            if (squareIsInvalid(0, 6, grid)) return true;

            return false;

        case MIDDLE:
            if (squareIsInvalid(3, 0, grid)) return true;
            if (squareIsInvalid(3, 3, grid)) return true;
            if (squareIsInvalid(3, 6, grid)) return true;
            return false;

        case BOTTOM:
            if (squareIsInvalid(6, 0, grid)) return true;
            if (squareIsInvalid(6, 3, grid)) return true;
            if (squareIsInvalid(6, 6, grid)) return true;
            return false;

        default:
            return false;                                                    /*If it passes all the tests, returns false. */
    }
}

public static boolean squareIsInvalid(int yIndex, int xIndex, int[][] grid) { /*This method checks if the squares of the puzzle are invalid a row of 3 values at a time.*/
    int yIndexEnd = yIndex + 3; 
    int xIndexEnd = xIndex + 3;

    List<Integer> square = new ArrayList<>();

    while (yIndex < yIndexEnd) {

        while (xIndex < xIndexEnd) {        /*Makes a row of 3 and adds it to the collection square*/
            square.add(
                    grid[xIndex][yIndex]
            );
            xIndex++;                       
        }

        xIndex -= 3;                        /*After the row is added into the collection reset the x position.*/

        yIndex++;                           /*After reseting the x position add 1 into the y position so the the run in the while loop adds the second row of 3 below. */
    }

    if (collectionHasRepeats(square)) return true;        
    return false;                                           /*If all goes well return false*/
}

public static boolean tilesAreNotFilled(int[][] grid) {         /*Method to check if the puzzle contains any zeroes, so it returns true, if the tiles are not fully filled. */
    for (int xIndex = 0; xIndex < 9; xIndex++) {
        for (int yIndex = 0; yIndex < 9; yIndex++) {
            if (grid[xIndex][yIndex] == 0) return true;
        }
    }
    return false;                                               /*If the tiles are fully filled return false*/
}   


}