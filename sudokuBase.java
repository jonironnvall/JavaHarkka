import java.util.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;                                             /**imports needed for GUI */

import javax.swing.*;
public class sudokuBase implements ActionListener{
   
    public static void generateGrid(int sudokuSize){
        int sudokuGrid [][]=new int [0][0];                                     /** I left the sudokugrid here to visualize that we could spawn a grid in this methog */  

       
    }
    public static void main (String[]args){                                      /** Added the main method for running the program */
        difficultyGUI diffGui=new difficultyGUI();                               /** Instance of the class is created in order to run the main method */
        diffGui.main(args);                                                      /** Syntax for running the main method */

    }
    public void actionPerformed(ActionEvent a){                                  /** This is here just in case we build the GUI onto this file and not a separate one */
        
        

    }
}
