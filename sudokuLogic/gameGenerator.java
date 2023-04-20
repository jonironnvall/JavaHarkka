package sudokuLogic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import sudokuLogic.coordinates;
import sudokuLogic.rows;



public class gameGenerator {


    public static int[][] solvedGameGeneration() {
        Random random = new Random(System.currentTimeMillis());     /* Creating a random number generator */
        int[][] newGrid = new int[9][9];                            /* NOTE: this part is now usable for only 9 x 9 grids, smaller ones are off the table with this */
        
        for (int value = 1; value <= 9; value++){                   /* Outer for loop for making sure dublicate numbers in the same positions wont occur. Tests all positions */
            int allocations = 0;
            int interrupt = 0;
            int tries = 0;
            List<coordinates> allocTracker = new ArrayList<>();

            tries++;

            while (allocations < 9){
                if(interrupt > 200){
                    allocTracker.forEach(coord -> {
                        newGrid[coord.getX()][coord.getY()] = 0;   });
                        
                        allocations = 0;
                        interrupt = 0;
                        allocTracker.clear();
                         tries++;
                
                        if (tries > 500) {
                            nukeCurrentGame(newGrid);
                            tries = 0;
                            value = 1;
                }
            }
            int xCoordinate = random.nextInt(9);
            int yCoordinate = random.nextInt(9);

            if(newGrid[xCoordinate][yCoordinate] == 0){
                newGrid[xCoordinate][yCoordinate] = value;
                
                if(invalidsudoku(newGrid)) {
                    newGrid[xCoordinate][yCoordinate] = 0;
                    interrupt++;
            }
            else {
                allocTracker.add(new coordinates(xCoordinate, yCoordinate));
                allocations++;
                }
             }
          }
        }
    
        
    System.out.println(tilesAreNotFilled(newGrid));
    System.out.println(Arrays.deepToString(newGrid));
    return newGrid;
}

    public static void nukeCurrentGame(int[][] newGrid){                       /* if all goes wrong there has to be an escape to "nuke" the whole program BOOM ; . o*/
        for(int x = 0; x < 9; x++){
            for(int y= 0; y < 9; y++){
                newGrid[x][y]= 0;
            }
        }

    }

    public static boolean checkForCompletion(int[][] newGrid) {
        if (invalidsudoku(newGrid)) return false;
        if (tilesAreNotFilled(newGrid)) return false;
        return true;
    }

public static boolean invalidsudoku(int[][] newGrid){
    if(rowsAreInvalid(newGrid)) return true;
    if(columnsAreInvalid(newGrid)) return true;
    if(squaresAreInvalid(newGrid)) return true;
    else return false;


}

public static boolean columnsAreInvalid(int[][] newGrid){
    for (int xIndex = 0; xIndex < 9; xIndex++){
        List<Integer> row = new ArrayList<>();
        for(int yIndex = 0; yIndex <9; yIndex++){
            row.add(newGrid[xIndex][yIndex]);

    }
        if (collectionHasRepeats(row)) return true;
}
    return false;
}
public static boolean rowsAreInvalid(int[][] newGrid){
    for (int yIndex = 0; yIndex < 9; yIndex++){
        List<Integer> row = new ArrayList<>();
        for(int xIndex = 0; xIndex <9; xIndex++){
            row.add(newGrid[xIndex][yIndex]);

    }
        if (collectionHasRepeats(row)) return true;
}
    return false;

}

public static boolean collectionHasRepeats(List<Integer> collection) {
    for (int index = 1; index <= 9; index++) {
        if (Collections.frequency(collection, index) > 1) return true;
    }

    return false;
}


public static boolean squaresAreInvalid(int[][] grid) {
    if (rowOfSquaresIsInvalid(rows.TOP, grid)) return true;

    if (rowOfSquaresIsInvalid(rows.MIDDLE, grid)) return true;

    if (rowOfSquaresIsInvalid(rows.BOTTOM, grid)) return true;

    return false;



}

private static boolean rowOfSquaresIsInvalid(rows value, int[][] grid) {
    switch (value) {
        case TOP:
            if (squareIsInvalid(0, 0, grid)) return true;
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
            return false;
    }
}

public static boolean squareIsInvalid(int yIndex, int xIndex, int[][] grid) {
    int yIndexEnd = yIndex + 3;
    int xIndexEnd = xIndex + 3;

    List<Integer> square = new ArrayList<>();

    while (yIndex < yIndexEnd) {

        while (xIndex < xIndexEnd) {
            square.add(
                    grid[xIndex][yIndex]
            );
            xIndex++;
        }

        //reset x to original value by subtracting by 2
        xIndex -= 3;

        yIndex++;
    }

    //if square has repeats, return true
    if (collectionHasRepeats(square)) return true;
    return false;
}

public static boolean tilesAreNotFilled(int[][] grid) {
    for (int xIndex = 0; xIndex < 9; xIndex++) {
        for (int yIndex = 0; yIndex < 9; yIndex++) {
            if (grid[xIndex][yIndex] == 0) return true;
        }
    }
    return false;
}


}