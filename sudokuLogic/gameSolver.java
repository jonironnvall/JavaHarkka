package sudokuLogic;

public class gameSolver {



/*   BEGINNER METHODS                   */
/*   BEGINNER METHODS                   */
/*   BEGINNER METHODS                   */
    public static boolean beginnerIsSolvable(int [][] puzzle){
        coordinates[] emptyCells = beginnerEnumerate(puzzle);
            int index = 0;
            int input = 1;
            while (index < 10) {
                coordinates current = emptyCells[index];
                input = 1;
                while (input < 40) {
                    puzzle[current.getX()][current.getY()] = input;
                    if (gameGenerator.invalidSudoku(puzzle)) {
                        if (index == 0 && input == 9) {
                            return false;
                        } else if (input == 9) {
                            index--;
                        }
    
                        input++;
                    } else {
                        index++;
    
                        if (index == 39) {
                            return true;
                        }
    
                        input = 10;
                    }
                }
            }
    
            return false;
        }
    
    
    
    
    
    private static coordinates[] beginnerEnumerate(int[][] puzzle){
        coordinates[] emptyCells = new coordinates[40];
        int iterator = 0;
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 9; x++){
                if(puzzle[x][y]== 0){
                    emptyCells[iterator] = new coordinates(x,y);
                    if(iterator == 39) return emptyCells;
                    iterator++;
                }
            }
        }
    
    
    return emptyCells;
        }
    
    



/*   CASUAL METHODS                   */
/*   CASUAL METHODS                   */
/*   CASUAL METHODS                   */
public static boolean casualIsSolvable(int [][] puzzle){
    coordinates[] emptyCells = casualEnumerate(puzzle);
        int index = 0;
        int input = 1;
        while (index < 10) {
            coordinates current = emptyCells[index];
            input = 1;
            while (input < 40) {
                puzzle[current.getX()][current.getY()] = input;
                if (gameGenerator.invalidSudoku(puzzle)) {
                    if (index == 0 && input == 9) {
                        return false;
                    } else if (input == 9) {
                        index--;
                    }

                    input++;
                } else {
                    index++;

                    if (index == 39) {
                        return true;
                    }

                    input = 10;
                }
            }
        }

        return false;
    }





private static coordinates[] casualEnumerate(int[][] puzzle){
    coordinates[] emptyCells = new coordinates[40];
    int iterator = 0;
    for(int y = 0; y < 9; y++){
        for(int x = 0; x < 9; x++){
            if(puzzle[x][y]== 0){
                emptyCells[iterator] = new coordinates(x,y);
                if(iterator == 39) return emptyCells;
                iterator++;
            }
        }
    }


return emptyCells;
    }


/*   ADVANCED METHODS                   */
/*   ADVANCED METHODS                   */
/*   ADVANCED METHODS                   */

    public static boolean advancedIsSolvable(int [][] puzzle){
        coordinates[] emptyCells = advancedEnumerate(puzzle);
            int index = 0;
            int input = 1;
            while (index < 10) {
                coordinates current = emptyCells[index];
                input = 1;
                while (input < 40) {
                    puzzle[current.getX()][current.getY()] = input;
                    if (gameGenerator.invalidSudoku(puzzle)) {
                        if (index == 0 && input == 9) {
                            return false;
                        } else if (input == 9) {
                            index--;
                        }
    
                        input++;
                    } else {
                        index++;
    
                        if (index == 39) {
                            return true;
                        }
    
                        input = 10;
                    }
                }
            }
    
            return false;
        }
    
    
    
    
    
    private static coordinates[] advancedEnumerate(int[][] puzzle){
        coordinates[] emptyCells = new coordinates[40];
        int iterator = 0;
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 9; x++){
                if(puzzle[x][y]== 0){
                    emptyCells[iterator] = new coordinates(x,y);
                    if(iterator == 39) return emptyCells;
                    iterator++;
                }
            }
        }
    
    
    return emptyCells;
        }
    }
     

