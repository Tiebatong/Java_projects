import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game implements ActionListener {

    JButton[] buttons;
    boolean Spieler_Zug = true;
    boolean[] Feld_besetzt = {false, false, false, false, false, false, false, false, false};
    char[] Spielfeld = {};






    public Game() {

        JFrame frame = new JFrame();

        buttons = new JButton[9];



        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton(" ");
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.lightGray);
            frame.add(buttons[i]);

        }
        buttons[0].setBounds(100, 100, 50, 50);
        buttons[1].setBounds(160, 100, 50, 50);
        buttons[2].setBounds(220, 100, 50, 50);
        buttons[3].setBounds(100, 160, 50, 50);
        buttons[4].setBounds(160, 160, 50, 50);
        buttons[5].setBounds(220, 160, 50, 50);
        buttons[6].setBounds(100, 220, 50, 50);
        buttons[7].setBounds(160, 220, 50, 50);
        buttons[8].setBounds(220, 220, 50, 50);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(380, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setResizable(false);

    }

    public static void main(String[] args ) {
        new Game();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        int Computer_Zug = 0;
        Random rand = new Random();
        boolean valider_Zug = true;
        while(valider_Zug) {
            Computer_Zug = rand.nextInt(9);
            for(int i = 0; i < 9; i++) {
                if(!Feld_besetzt[Computer_Zug]) {
                    valider_Zug = false;
                }

            }

        }



        for(int x = 0; x < 9; x++) {
            if(Spieler_Zug) {
                for(int i = 0; i < 9; i++) {
                    if(e.getSource() == buttons[i]) {
                        buttons[i].setText("X");
                        Spieler_Zug = false;
                        Feld_besetzt[i] = true;
                        break;
                    }
                }
            } else {

                buttons[Computer_Zug].setText("O");
                Spieler_Zug = true;
                Feld_besetzt[Computer_Zug] = true;
            }
        }



    }

}
