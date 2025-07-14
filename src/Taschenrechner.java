import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Taschenrechner implements ActionListener {

    JButton[] number_buttons;

    public Taschenrechner() {

        number_buttons = new JButton[10];

        JFrame frame = new JFrame();

        for(int i = 0; i < 10; i++) {


            number_buttons[i] = new JButton();
            number_buttons[i].setFocusable(false);
            number_buttons[i].addActionListener(this);
            number_buttons[i].setText("" + i);
            frame.add(number_buttons[i]);
        }


        number_buttons[1].setBounds(100, 100, 50, 50);
        number_buttons[2].setBounds(160, 100, 50, 50);
        number_buttons[3].setBounds(220, 100, 50, 50);
        number_buttons[4].setBounds(100, 160, 50, 50);
        number_buttons[5].setBounds(160, 160, 50, 50);
        number_buttons[6].setBounds(220, 160, 50, 50);
        number_buttons[7].setBounds(100, 220, 50, 50);
        number_buttons[8].setBounds(160, 220, 50, 50);
        number_buttons[9].setBounds(220, 220, 50, 50);
        number_buttons[0].setBounds(160, 280, 50, 50);


        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public static void main(String[] args ) {
        new Taschenrechner();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 10; i++) {
            if(e.getSource() == number_buttons[i]) {
                number_buttons[i].setText("x");
                System.out.println(i);
            }
        }
    }
}
