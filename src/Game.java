import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {

    JButton[9] buttons;

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;

    public Game() {

        JFrame frame = new JFrame();

        buttons[] =

        button1 = new JButton(" ");
        button2 = new JButton(" ");
        button3 = new JButton(" ");
        button4 = new JButton(" ");

        button1.setFocusable(false);
        button1.setBounds(100, 100, 50, 50);
        button1.addActionListener(this);

        button2.setFocusable(false);
        button2.setBounds(160, 100, 50, 50);
        button2.addActionListener(this);

        frame.add(button1);
        frame.add(button2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String[] args ) {
        new Game();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            button1.setText("X");
        }
        if (e.getSource() == button2) {
            button2.setText("O");
        }
    }

}
