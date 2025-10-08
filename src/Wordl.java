import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wordl implements ActionListener {

    char[] Loesungswort = {'L', 'A', 'M', 'P', 'E'};
    JFrame frame;
    JTextField[] Text_buttons;
    JTextField textField;
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
        textField = new JTextField();

        int index = 0;
        int Lindex = 0;
        int Xindex = 500;
        int Yindex = 150;
        int Breite = 70;
        int Hoehe = 70;



        for(int i = 1; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                Text_buttons[index] = new JTextField();
                Text_buttons[index].setBounds(Xindex + 80 * j, Yindex , Breite, Hoehe);
                Text_buttons[index].setEditable(false);
                Text_buttons[index].setBackground(Color.LIGHT_GRAY);
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
            Letter_buttons[Lindex].setBackground(Color.LIGHT_GRAY);
            Letter_buttons[Lindex].setFont(new Font("Arial", Font.BOLD,16));
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
            Letter_buttons[Lindex].setBackground(Color.LIGHT_GRAY);
            Letter_buttons[Lindex].setFont(new Font("Arial", Font.BOLD,16));
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
            Letter_buttons[Lindex].setBackground(Color.LIGHT_GRAY);
            Letter_buttons[Lindex].setFont(new Font("Arial", Font.BOLD,16));
            frame.add(Letter_buttons[Lindex]);
            Lindex++;
        }

        Delete_button.setText("delete");
        Delete_button.setBounds(420, 760, 80, 50);
        Delete_button.setFocusable(false);
        Delete_button.addActionListener(this);
        Delete_button.setBackground(Color.LIGHT_GRAY);
        frame.add(Delete_button);

        Enter_button.setText("enter");
        Enter_button.setBounds(890, 760, 80, 50);
        Enter_button.setFocusable(false);
        Enter_button.addActionListener(this);
        Enter_button.setBackground(Color.LIGHT_GRAY);
        frame.add(Enter_button);

        textField.setEditable(false);
        textField.setBounds(500, 20, 390, 100);
        textField.setBackground(Color.LIGHT_GRAY);
        frame.add(textField);

        frame.setTitle("Wordl");
        frame.setBounds(600, 200, 1500, 1000);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setVisible(true);

    }
    public static void main(String[] args) {new Wordl(); }

    int letter_count = 0;
    int Runde = 0;
    int buchstaben_richtig = 0;
    @Override
    public void actionPerformed(ActionEvent e) {


        for(int i = 0; i < 26; i++) {
            if(e.getSource() == Letter_buttons[i]) {
                Text_buttons[buttons_pressed].setText("" + Letter_array[i]);
                Text_buttons[buttons_pressed].setFont(new Font("Arial", Font.BOLD,30));
                Text_buttons[buttons_pressed].setHorizontalAlignment(SwingConstants.CENTER);
                buttons_pressed++;
            }
        }
        if(e.getSource() == Delete_button) {
            Text_buttons[buttons_pressed - 1].setText("");
            buttons_pressed--;
        }
        if(e.getSource() == Enter_button) {
            for(int i = 0; i < 5; i++) {
                char tmp = Text_buttons[i + letter_count].getText().charAt(0);
                if(tmp == Loesungswort[i]) {
                    Text_buttons[i + letter_count].setBackground(Color.GREEN);
                    for (int j = 0; j < Letter_array.length; j++) {
                        if (tmp == Letter_array[j]) {
                            Letter_buttons[j].setBackground(Color.GREEN);
                        }
                    }
                    buchstaben_richtig++;
                } else if (tmp != Loesungswort[0] && tmp != Loesungswort[1] && tmp != Loesungswort[2] && tmp != Loesungswort[3] && tmp != Loesungswort[4]) {
                    Text_buttons[i + letter_count].setBackground(Color.RED);
                    for (int j = 0; j < Letter_array.length; j++) {
                        if (tmp == Letter_array[j]) {
                            Letter_buttons[j].setBackground(Color.RED);
                        }
                    }
                } else {
                    Text_buttons[i + letter_count].setBackground(Color.YELLOW);
                    for (int j = 0; j < Letter_array.length; j++) {
                        if (tmp == Letter_array[j]) {
                            Letter_buttons[j].setBackground(Color.YELLOW);
                        }
                    }
                }
            }
            Runde++;
            System.out.println(Runde);
            if(buchstaben_richtig == 5 && Runde <= 6) {
                textField.setText("GEWONNEN");
                textField.setFont(new Font("Arial", Font.BOLD,50));
                textField.setHorizontalAlignment(SwingConstants.CENTER);
                Enter_button.setEnabled(false);
                Delete_button.setEnabled(false);
                for(int n = 0; n < 26; n++) {
                    Letter_buttons[n].setEnabled(false);
                }
            } else if ( buchstaben_richtig != 5 && Runde == 6){
                String String_Loesungswort = new String(Loesungswort);
                textField.setText("Das Wort war: " + String_Loesungswort);
                textField.setFont(new Font("Arial", Font.BOLD,32));
                textField.setHorizontalAlignment(SwingConstants.CENTER);
                Enter_button.setEnabled(false);
                Delete_button.setEnabled(false);
                for(int n = 0; n < 26; n++) {
                    Letter_buttons[n].setEnabled(false);
                }
            }
            buchstaben_richtig = 0;
            letter_count = letter_count + 5;
        }
    }
}
