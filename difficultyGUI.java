import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
public class difficultyGUI implements ActionListener {
    private static JLabel difficultyLabel;         /** Text label for displaying users choice */
    private static JLabel userChoice;
    
    private static JFrame frame;
    private static JPanel panel;
    
    private static JButton beginnerButton;         /** Initializing buttons for the different difficulties */
    private static JButton casualButton;
    private static JButton advancedButton;

    public void main (String[]args){
        frame = new JFrame();
        frame.setSize(350,200);    /** Frame is the window */

        panel = new JPanel();  /** Panel is the layout */
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));  /** Setting the border of the panel */
        
        frame.add(panel, BorderLayout.CENTER);                     /** Border layout still in progress, but is set to center for now */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      /** Setting what happends from the X */
        frame.setTitle("LobsterSudoku");
        frame.pack();
        frame.setVisible(true);                                 /** Makes the window "Excist" */

        difficultyLabel=new JLabel("Choose difficulty");       /** Text label */
        difficultyLabel.setBounds(10,30,90,10);
        panel.add(difficultyLabel);                                /** Adding label to the panel aka the layout */

        userChoice=new JLabel("");                             /** Text label */
        userChoice.setBounds(10,50,80,10);
        panel.add(userChoice);                                       /** Adding label to the panel aka the layout */

        beginnerButton = new JButton("Beginner");
        beginnerButton.setBounds(10,100,80,50);     /** Button customization */
        beginnerButton.addActionListener(new difficultyGUI());
        panel.add(beginnerButton);                                  /** Adding button to the panel */

        casualButton = new JButton("Casual");                  
        casualButton.setBounds(10,80,80,25);       /** Button customization */
        casualButton.addActionListener(new difficultyGUI());       
        panel.add(casualButton);                                    /** Adding button to the panel */

        advancedButton = new JButton("Advanced");
        advancedButton.setBounds(10,80,80,25);     /** Button customization */
        advancedButton.addActionListener(new difficultyGUI());
        panel.add(advancedButton);                                 /** Adding button to the panel */

    }
    public void actionPerformed(ActionEvent e) {                   /** actionPerformed method is tied to the implemented actionlistener
                                                                   * of the class. All button clicks and their functions are registered here */ 

        if (e.getSource()==beginnerButton){
            
            userChoice.setText("You chose the beginner difficulty:");
        }
        else if (e.getSource()==casualButton){
            userChoice.setText("You chose the casual difficulty:");
        }
        else if (e.getSource()==advancedButton){
            userChoice.setText("You chose the advanced difficulty:");

        }
        /**These if statements are here to determine the next step in the program: 
         * Which ever button the user presses will lead them to a different method based on the difficulty level
         * !!THIS PART STILL NEEDS WORK AND DISCUSSION 
         */


    }
    
}
