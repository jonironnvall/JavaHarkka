import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class endScreenWin implements ActionListener {
    private static JLabel endText;      /** Text label for displaying the outcome of the game */
    private static JLabel userChoice;
    
    private static JFrame frame;
    private static JPanel panel;

    private static JButton menuButton;      /** Initializing button for going back to main menu */

    public void main(String[] args) {
        frame = new JFrame();
        frame.setSize(350, 200); /** Frame and its default size */

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        frame.add(panel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("LobsterSudoku");
        frame.setVisible(true);

        endText = new JLabel("YOU WON!!!!!!!!"); /** Text displaying that the player completed the sudoku successfully */
        endText.setBounds(0, 10, 90, 10);
        panel.add(endText);

        userChoice=new JLabel("");
        userChoice.setBounds(80,50,80,10);
        panel.add(userChoice);

        menuButton = new JButton("Back to main menu"); /** A button that returns the user back to main menu when pressed */
        menuButton.setBounds(80, 80, 80, 25);
        menuButton.addActionListener(new endScreenWin());
        panel.add(menuButton);
    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==menuButton) {
            
            userChoice.setText("You chose to go back to main menu:"); /** ??? Not sure how to get this to return the user to main menu, but will figure it out */ 
            sudokuBase sdkbase = new sudokuBase();
            frame.setVisible(false);

        }
    }
}