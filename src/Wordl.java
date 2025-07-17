import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wordl implements ActionListener {

    JFrame frame;
    JTextField[] Text_buttons;

    public Wordl() {

        frame = new JFrame();

        int index = 0;
        int Xindex = 500;
        int Yindex = 100;
        int Breite = 70;
        int Hoehe = 70;

        Text_buttons = new JTextField[30];

        for(int i = 1; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                Text_buttons[index] = new JTextField();
                Text_buttons[index].setText("" + index);
                Text_buttons[index].setBounds(Xindex + 80 * j, Yindex , Breite, Hoehe);
                Text_buttons[index].setEditable(false);
                Text_buttons[index].addActionListener(this);
                //Text_buttons[index].setBackground(Color.DARK_GRAY);
                frame.add(Text_buttons[index]);
                index++;
            }
            Yindex += (Hoehe + 10);
        }




        frame.setTitle("Wordl");
        frame.setBounds(600, 200, 1500, 1000);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.DARK_GRAY);
        frame.setVisible(true);

    }
    public static void main(String[] args) {new Wordl(); }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
