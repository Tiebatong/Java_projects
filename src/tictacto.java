import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tictacto implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] Spielfeld = new JButton[9];
    JButton Spielfeld1, Spielfeld2 , Spielfeld3 , Spielfeld4 , Spielfeld5 , Spielfeld6 , Spielfeld7 , Spielfeld8 , Spielfeld9;

    tictacto() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        JPanel panel = new JPanel();

        Spielfeld1 = new JButton("test");

        panel.add(Spielfeld1);

        frame.setVisible(true);

    }
    public static void main(String[] args) {

        tictacto tic = new tictacto();

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}