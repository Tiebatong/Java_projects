import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wordl implements ActionListener {

    JFrame frame;
    JTextField[] Text_buttons;
    JButton[] Letter_buttons;
    JButton Delete_button;
    JButton Enter_button;
    char[] Letter_array = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
    int buttons_pressed = 0;

    public Wordl() {


        frame = new JFrame();
        Text_buttons = new JTextField[30];
        Letter_buttons = new JButton[26];
        Delete_button = new JButton();
        Enter_button = new JButton();

        int index = 0;
        int Lindex = 0;
        int Xindex = 500;
        int Yindex = 100;
        int Breite = 70;
        int Hoehe = 70;



        for(int i = 1; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                Text_buttons[index] = new JTextField();
                Text_buttons[index].setText("" + index);
                Text_buttons[index].setBounds(Xindex + 80 * j, Yindex , Breite, Hoehe);
                Text_buttons[index].setEditable(false);
                //Text_buttons[index].setBackground(Color.DARK_GRAY);
                frame.add(Text_buttons[index]);
                index++;
            }
            Yindex += (Hoehe + 10);
        }
        for(int i = 0; i < 10; i++) {
            Letter_buttons[Lindex] = new JButton();
            Letter_buttons[Lindex].setText("" + Letter_array[Lindex]);
            Letter_buttons[Lindex].setBounds(420 + (55 * i),  650 , 50, 50);
            Letter_buttons[Lindex].setFocusable(false);
            Letter_buttons[Lindex].addActionListener(this);
            frame.add(Letter_buttons[Lindex]);
            Lindex++;
        }
        Lindex = 10;
        for(int i = 0; i < 9; i++) {
            Letter_buttons[Lindex] = new JButton();
            Letter_buttons[Lindex].setText("" + Letter_array[Lindex]);
            Letter_buttons[Lindex].setBounds(450 + (55 * i),  705 , 50, 50);
            Letter_buttons[Lindex].setFocusable(false);
            Letter_buttons[Lindex].addActionListener(this);
            frame.add(Letter_buttons[Lindex]);
            Lindex++;
        }
        Lindex = 19;
        for(int i = 0; i < 7; i++) {
            Letter_buttons[Lindex] = new JButton();
            Letter_buttons[Lindex].setText("" + Letter_array[Lindex]);
            Letter_buttons[Lindex].setBounds(505 + (55 * i),  760 , 50, 50);
            Letter_buttons[Lindex].setFocusable(false);
            Letter_buttons[Lindex].addActionListener(this);
            frame.add(Letter_buttons[Lindex]);
            Lindex++;
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


        for(int i = 0; i < 26; i++) {
            if(e.getSource() == Letter_buttons[i]) {
                Text_buttons[buttons_pressed].setText("" + Letter_array[i]);
                buttons_pressed++;
            }
        }

    }
}
