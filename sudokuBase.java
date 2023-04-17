import java.util.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;    
import java.awt.GridLayout;                                         /**imports needed for GUI */


import javax.swing.*;
public class sudokuBase implements ActionListener{
    private static JFrame frame;
    private static JPanel panel;
    private static JTextField [][] textFields;     /** !!PLEASE NOTE: THIS HERE IS THE PART WHERE YOU CAN USE ANY DATA TYPE LIKE ARRAYS. CHANGE THIS IF YOU WISH TO USE A DIFFERENT DATATYPE FROM 2D ARRAYS!! */
    private static int row;
    private static int column;
    private static JTextField textField;
   
    public void generateGrid(int sudokuSize){
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
        //panel=new JPanel();

       textFields=new JTextField[9][9];    /** Setting up the array */

        for (int row=0;row<9;row++){
            frame.setLayout(new GridLayout(9,9));   /** This creates the sudoku grid */
            for (int column=0;column<9;column++){             /** This creates the contents of the grid where user can input numbers */
                //frame.add(new JTextField(column));          /** Possibly another way to add these columns, still under work */
                textField=new JTextField(column); 
                textFields[row][column]=textField;
                textField.addActionListener(new sudokuBase());  /** Adds this class as the actionlistener everything happening in this class is tied to the actionperformed method and should be handled there */
                frame.add(textField);                           /** Adds textfield to the frame aka makes it visible */
            }
        }
        
    }

    
    public static void main (String[]args){                                      /** Added the main method for running the program */
        difficultyGUI diffGui=new difficultyGUI();                               /** Instance of the class is created in order to run the main method */
        diffGui.main(args);                                                      /** Syntax for running the main method of difficultyGUI */

    }
    public void actionPerformed(ActionEvent a){                                  /** This is here just in case we build the GUI onto this file and not a separate one */
       
        Object inputSource = a.getSource();                                      /** Here we are making an object out of the source of the action */
        if (inputSource instanceof JTextField){                                  /**the action is then checked and if it comes from the JTextfield it is fetched*/
            JTextField textField = (JTextField) inputSource;                     /**  using the getText() method.*/
                                     
            int sudokuNumber=Integer.parseInt(textField.getText());              /**   Here the textfield is parsed to convert the string to an integer */
            System.out.println(sudokuNumber);                                    /** This is a terminal print to check if this code snippet works properly */
        }
    }
}
