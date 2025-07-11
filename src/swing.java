import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;

public class swing {

    public static void main(String[] args ) {

        ImageIcon image = new ImageIcon("logo.png");

        JLabel label = new JLabel(); // create new label

        label.setText("Rotfront"); // set text of label
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(175,50,90)); // set font color
        label.setFont(new Font("MV Boli",Font.BOLD, 50)); // set font color of text
        label.setIconTextGap(10); // set gap of text to image
        label.setBackground(Color.blue);
        label.setOpaque(true);

        JFrame frame = new JFrame(); // creates new frame

        frame.setTitle("Titel des Fensters"); // steht oben im Fenster
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes the window when clicking X button
        frame.setSize(1000,1000);
        frame.setVisible(true);
        frame.add(label); // adds label to frame


    }
}
