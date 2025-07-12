import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game implements ActionListener {

    JButton[] buttons;
    JTextField text;
    boolean Spieler_Zug = true;
    boolean[] Feld_besetzt = {false, false, false, false, false, false, false, false, false};
    char[] Spielfeld = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
    int Zuege_Count = 0;







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


        text = new JTextField();
        text.setBounds(140, 20, 100, 50);
        text.setEditable(false);
        text.setBackground(Color.LIGHT_GRAY);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(380, 400);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.add(text);
        frame.setResizable(false);
        frame.setVisible(true);


    }
    public int Check_gewonnen(char[] Spielfeld, int Spieler) {

        char z = 'X';          // int Spieler = 1 heisst Spieler
        if(Spieler == 2) {     // int Spieler = 2 heisst Computer
            z = 'O';           // return 3 heisst keiner hat gewonnen
        }

        if(Spielfeld[0] == z && Spielfeld[1] == z && Spielfeld[2] == z) {
            return Spieler;
        } else if (Spielfeld[3] == z && Spielfeld[4] == z && Spielfeld[5] == z) {
            return  Spieler;
        }  else if (Spielfeld[6] == z && Spielfeld[7] == z && Spielfeld[8] == z) {
            return  Spieler;
        }  else if (Spielfeld[0] == z && Spielfeld[3] == z && Spielfeld[6] == z) {
            return  Spieler;
        }  else if (Spielfeld[1] == z && Spielfeld[4] == z && Spielfeld[7] == z) {
            return  Spieler;
        }  else if (Spielfeld[2] == z && Spielfeld[5] == z && Spielfeld[8] == z) {
            return  Spieler;
        }  else if (Spielfeld[0] == z && Spielfeld[4] == z && Spielfeld[8] == z) {
            return  Spieler;
        }  else if (Spielfeld[2] == z && Spielfeld[4] == z && Spielfeld[6] == z) {
            return  Spieler;
        } else {
            return 3;
        }
    }


    public static void main(String[] args ) {
        new Game();
    }
    @Override
    public void actionPerformed(ActionEvent e) {


        if(Spieler_Zug) {
            for(int i = 0; i < 9; i++) {
                if(e.getSource() == buttons[i] && !Feld_besetzt[i]) {
                    buttons[i].setText("X");
                    Spielfeld[i] = 'X';
                    Spieler_Zug = false;
                    Feld_besetzt[i] = true;
                    Zuege_Count++;

                    if(Check_gewonnen(Spielfeld, 1) == 1) {
                        text.setText("GEWONNEN");
                        for(int x = 0; x < 9; x++) {
                            buttons[x].setEnabled(false);
                        }

                    }  else if (Zuege_Count == 9 && Check_gewonnen(Spielfeld, 1) == 3) {
                        text.setText("Unentschieden");

                    }

                    break;

                }
            }

        }

        if(!Spieler_Zug && Zuege_Count != 9) {
            int Computer_Zug;
            Random rand = new Random();

            do {
                Computer_Zug = rand.nextInt(9);
            } while (Feld_besetzt[Computer_Zug]);

            buttons[Computer_Zug].setText("O");
            Spielfeld[Computer_Zug] = 'O';
            Spieler_Zug = true;
            Feld_besetzt[Computer_Zug] = true;
            Zuege_Count++;

            if (Check_gewonnen(Spielfeld, 2) == 2) {
                text.setText("VERLOREN");
                for(int x = 0; x < 9; x++) {
                    buttons[x].setEnabled(false);
                }
            } else if (Zuege_Count == 9 && Check_gewonnen(Spielfeld, 2) == 3) {
                text.setText("Unentschieden");

            }

        }

    }

}
