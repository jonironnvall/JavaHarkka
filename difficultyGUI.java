import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;
public class difficultyGUI implements ActionListener {
    private static JLabel difficultyLabel;         /** Text label for displaying users choice */
    private static JLabel userChoice;
    
    private static JFrame frame;
    private static JPanel panel;
    
    private static JButton beginnerButton;         /** Initializing buttons for the different difficulties */
    private static JButton casualButton;
    private static JButton advancedButton;
   // private static Container con = getContentPane();

    public void main (String[]args){
        frame = new lobsterBg();
        frame.setSize(800,500);    /** Frame is the window */
        frame.setResizable(false);

        panel = new JPanel();  /** Panel is the layout */
        //panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));  /** Setting the border of the panel */
        
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      /** Setting what happends from the X */
        frame.setTitle("LobsterSudoku");
        //frame.setVisible(true);                                 /** Makes the window "Excist" */

        difficultyLabel=new JLabel("Choose difficulty");       /** Text label */
        //difficultyLabel.setBounds(0,10,90,10);
        //panel.setLayout(new GridLayout());  /** Possible solution to the placement issue */
        panel.add(difficultyLabel);   /** Adding label to the panel aka the layout. I commented this away until the placement is decided as this is intefearing with the placement of the buttons*/

        userChoice=new JLabel("");                             /** Text label */
        userChoice.setBounds(80,50,80,10);
                                            /** Adding label to the panel aka the layout */

        beginnerButton = new JButton("Beginner");
        beginnerButton.setBounds(80,80,80,25);     /** Button placement and size customization */
        beginnerButton.addActionListener(new difficultyGUI());
        panel.add(beginnerButton);                                  /** Adding button to the panel */

        casualButton = new JButton("Casual");                  
        casualButton.setBounds(80,100,80,25);       /** Button placement and size customization */
        casualButton.addActionListener(new difficultyGUI());       
        panel.add(casualButton);                                    /** Adding button to the panel */

        advancedButton = new JButton("Advanced");
        advancedButton.setBounds(10,120,80,25);     /** Button placement and size customization */
        advancedButton.addActionListener(new difficultyGUI());
        panel.add(advancedButton);                                 /** Adding button to the panel */

        
        frame.setVisible(true);
        frame.add(panel);                     /** Border layout still in progress, but is set to center for now */

    }
    public void actionPerformed(ActionEvent e) {                   /** actionPerformed method is tied to the implemented actionlistener
                                                                   * of the class. All button clicks and their functions are registered here */ 

        if (e.getSource()==beginnerButton){
            
            userChoice.setText("You chose the beginner difficulty:");
            sudokuBase sdkbase=new sudokuBase();
            sdkbase.generateGrid(4,false);   /** Here we call the grid method from the class sudokubase */
            frame.setVisible(false);            /** Here we set the difficulty window to close when user has chosen a level */
            
        }
        else if (e.getSource()==casualButton){
            userChoice.setText("You chose the casual difficulty:");
            sudokuBase sdkbase=new sudokuBase();
            sdkbase.generateGrid(4,false);   /** Here we call the grid method from the class sudokubase */
            frame.setVisible(false);            /** Here we set the difficulty window to close when user has chosen a level */
        }
        else if (e.getSource()==advancedButton){
            userChoice.setText("You chose the advanced difficulty:");
            sudokuBase sdkbase=new sudokuBase();
            sdkbase.generateGrid(4,false);   /** Here we call the grid method from the class sudokubase */
            frame.setVisible(false);            /** Here we set the difficulty window to close when user has chosen a level */

        }
        /**These if statements are here to determine the next step in the program: 
         * Which ever button the user presses will lead them to a different difficulty level sudoku
         * What kinds of return values could we assign here to determine the grid generation according to level selection?
         * !!THIS PART STILL NEEDS WORK AND DISCUSSION 
         */


    }
    
}
