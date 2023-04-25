import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class endScreenWin implements ActionListener {
    private static JLabel endText;      /** Text label for displaying the outcome of the game */
    private static JLabel userChoice;
    
    private static JFrame frame;
    private static JPanel panel;

    private static JButton menuButton;      /** Initializing button for going back to main menu */

    public void win (){
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
            try{
                // Create new file
                String content = "CONGRATULATIONS ON YOUR HUGE W!!!! Here's a diploma to show to your friends that PROVES you managed to solve a very basic sudoku! Thanks for playing.";
                String path="D:\\a\\Diploma.txt";
                File file = new File(path);
    
                // If file doesn't exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
    
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                // Write on file
                bw.write(content);
    
                bw.close();
            }
            catch(Exception o){
                System.out.println(o);
            }
        }
    }

    
    }
    
