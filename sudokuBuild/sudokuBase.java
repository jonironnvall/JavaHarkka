package sudokuBuild;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout; /**imports needed for GUI */
import java.util.Random;
import sudokuLogic.gameGenerator;


import javax.lang.model.type.NullType;
import javax.swing.*;
/**
    * sudokuBase implements ActionListener adds this class as the actionlistener every action
    * happening in this class is tied to the
    * actionperformed method and should be handled there
    */
public class sudokuBase implements ActionListener {
    private static JFrame frame;
    private static JPanel panel;
    private static JTextField[][] textFields;
    /**
     * !!PLEASE NOTE: THIS HERE IS THE PART WHERE YOU CAN USE ANY DATA TYPE LIKE
     * ARRAYS. CHANGE THIS IF YOU WISH TO USE A DIFFERENT DATATYPE FROM 2D ARRAYS!!
     */
    private static JTextField textField;
    private static JLabel machineNumber;
    private static boolean[][] numberPlacements;
    private static JButton submit;
/** generateGrid generates a sudokugrid and fills it with numbers so that it can be solved. It has some visual effects as well.
     * It has a returnarrayonly as a parameter so that the return value of the solved sudokunumbers can be accessed without calling the method again.
     * 
     * @param returnArrayOnly
     * @return
    */
    
    public int[][] generateGrid(int sudokuSize, boolean returnArrayOnly) {
        int[][] solvedSudokuNumbers = sudokuLogic.gameGenerator.solvedGameGeneration(); /** fully filled array */
        int[][] sudokuNumbers = sudokuLogic.gameGenerator.unsolveGameBeginner(solvedSudokuNumbers);/** unsolved array */
        if(!returnArrayOnly){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
        // panel=new JPanel();

        textFields = new JTextField[9][9]; /** Setting up the array */
        numberPlacements = new boolean[9][9]; /** Setting up the placements of the numbers */
        

        for (int row = 0; row < 9; row++) {
            frame.setLayout(new GridLayout(9, 9, 9, 6)); 
            /** This creates the sudoku grid */
            /**
             * Random number generator could be an external method, but it does function
             * here as well it still needs to have boundaries and limits set so that it
             * doesn't for example spawn the same number twice in the same 9x9 grid.
             */
            /**
             * frame.setBorder(BorderFactory.createEmptyBorder(2,2,2,2)); This is here to
             * set the border in between boxes. Still a bit in the dark how it's done
             */
            for (int column = 0; column < 9; column++) {
                int number = sudokuNumbers[row][column];
                /** This creates the contents of the grid where user can input numbers */
                if (number != 0) { /**
                                    * Could the checking method be called here or should we fill the array with
                                    * numbers in a separate method?
                                    */
                    machineNumber = new JLabel(Integer.toString(number)); /**
                                                                           * Note that these need to be converted back
                                                                           * to integers when worked with, JLabel only
                                                                           * holds strings
                                                                           */
                    numberPlacements[row][column] = true; /**
                                                           * This array can be used for checking the number placements
                                                           * as it changes every machine filled "alkio" value to true
                                                           */
                    frame.add(machineNumber); /** JLabels are added to the program */
                } else {
                    textField = new JTextField(column);
                    textFields[row][column] = textField;
                    textField.addActionListener(new sudokuBase()); /**
                                                                    * Adds this class as the actionlistener everything
                                                                    * happening in this class is tied to the
                                                                    * actionperformed method and should be handled there
                                                                    */
                    frame.add(textField); /** Adds textfield to the frame aka makes it visible */
                }

            }
            
        }
          //  submit = new JButton();
           // submit.setText("Submit");
           // frame.add(submit);
        // return numberPlacements; /** Just an idea, but you could use this return
        // value to determine the said coordinates of the values that need to be checked
        // for */
    }
    return solvedSudokuNumbers;

}

    /**
     * NEVERMIND!! This method apparelty has to be void or it affects the
     * functionality of the GUI.. But the boolean list could make sense when finding
     * the spots. Also the getsource method could work in the action performed
     * method as it can also find the placements. It could be worth looking into
     */

    public static void main(String[] args) { /** Added the main method for running the program */
        difficultyGUI diffGui = new difficultyGUI(); /**
                                                      * Instance of the class is created in order to run the main method
                                                      */
        diffGui.main(args); /** Syntax for running the main method of difficultyGUI */

    }

    public void actionPerformed(ActionEvent a) {
    int[][] solvedGame = generateGrid(4, true);
    final int[][] sudokuNumbers = sudokuLogic.gameGenerator.unsolveGameBeginner(solvedGame);

        Object inputSource = a.getSource();
        /** Here we are making an object out of the source of the action */
        if (inputSource instanceof JTextField) { /**
                                                  * the action is then checked and if it comes from the JTextfield it is
                                                  * fetched
                                                  */
            JTextField textField = (JTextField) inputSource; /** using the getText() method. */
        

                }

        
            

            System.out.println(); /**
                                               * This is a terminal print to check if this code snippet works properly
                                               */
        }
    }

