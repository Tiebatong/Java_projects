import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame() {
        JFrame frame = new JFrame(); // creates new frame


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes the window when clicking X button
        this.setResizable(false); // prevents frame from being resized
        this.setSize(420,420); // sets width and height
        this.setVisible(true); // makes frame visible

        ImageIcon image = new ImageIcon("logo.png"); // creates an image Icon
        this.setIconImage(image.getImage()); //sets Icon of the frame
        this.getContentPane().setBackground(new Color(175,50,90)); // change color of background
    }
}
