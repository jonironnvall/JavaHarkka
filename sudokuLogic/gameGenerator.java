package sudokuLogic;
import java.util.List;
import java.util.Random;




public class gameGenerator {

    public static int[][] solvedGameGeneration() {
        Random random = new Random(System.currentTimeMillis());     /* Creating a random number generator */
        int[][] newGrid = new int[9][9];                            /* NOTE: this part is now usable for only 9 x 9 grids, smaller ones are off the table with this */
        
        for (int value = 1; value <= 9; value++){                   /* Outer for loop for making sure dublicate numbers in the same positions wont occur. Tests all positions */
            int set = 0;
            int interrupt = 0;
            int tries = 0;
            tries++;

            while (set < 9){
                if(tries > 500){
                    nukeCurrentGame(newGrid);
                    interrupt = 0;
                    value = 1;
                }
            }
            int xCoordinate = random.nextInt(9);
            int yCoordinate = random.nextInt(9);

            if(newGrid[xCoordinate][yCoordinate] == 0){
                newGrid[xCoordinate][yCoordinate] = value;
                
                if(gameSolver.invalidSudoku(newGrid)) {
                    newGrid[xCoordinate][yCoordinate]= 0;
                    value--;                                           /* Experimental - needs some way to back track and try again, this aint it chief */
                    interrupt++;                                
                }
            }

        }
    System.out.println(newGrid);
    return newGrid;
}

    public static void nukeCurrentGame(int[][] newGrid){                       /* if all goes wrong there has to be an escape to "nuke" the whole program BOOM ; . o*/
        for(int x = 0; x < 9; x++){
            for(int y= 0; y < 9; y++){
                newGrid[x][y]= 0;
            }
        }
}

}