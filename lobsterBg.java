import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;

public class lobsterBg extends JFrame{

    JFrame background;
    public lobsterBg(){
        
        //File img = new File ("LobsterSudoku.jpeg"); /** Creating a File of the image */
        JLabel lobsterBackground = new JLabel(new ImageIcon("LobsterSudoku.jpeg")); /** Reading image from file */
        setSize(800,500);    /** Setting Size of imagewindow */
        setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //setVisible(true);              /** Setting the background visible */
        //setLayout(new BorderLayout());                       /** Setting a new layout */
        add(lobsterBackground);
        //setLayout(new FlowLayout());

    }
}
