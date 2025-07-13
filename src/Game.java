import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game implements ActionListener {

    JButton[] buttons;
    JButton close_button;
    JButton button_neustart;
    JTextField text;
    JTextField Spieler_gewonnen;
    boolean Spieler_Zug = true;
    boolean[] Feld_besetzt = {false, false, false, false, false, false, false, false, false};
    char[] Spielfeld = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
    int Zuege_Count = 0;
    int Spieler_win_counter = 0;
    int Computer_win_counter = 0;

    JFrame frame = new JFrame();


    public Game() {



        close_button = new JButton();
        close_button.setBounds(280, 300, 80, 50);
        close_button.setText("Exit");
        close_button.addActionListener(this);
        close_button.setBackground(Color.LIGHT_GRAY);
        close_button.setFont(new Font("Arial", Font.BOLD,15));
        close_button.setFocusable(false);

        Spieler_gewonnen = new JTextField();
        Spieler_gewonnen.setText("Du : " + Spieler_win_counter + "  |  " + Computer_win_counter + " : Computer");
        Spieler_gewonnen.setBounds(100, 20, 170, 50);
        Spieler_gewonnen.setBackground(Color.LIGHT_GRAY);
        Spieler_gewonnen.setForeground(Color.DARK_GRAY);
        Spieler_gewonnen.setEditable(false);
        Spieler_gewonnen.setHorizontalAlignment(SwingConstants.CENTER);
        Spieler_gewonnen.setFont(new Font("Arial", Font.BOLD,15));

        buttons = new JButton[9];


        button_neustart = new JButton();
        button_neustart.setText("Neue Runde");
        button_neustart.setBounds(115, 300,140,50);
        button_neustart.setForeground(Color.DARK_GRAY);
        button_neustart.setBackground(Color.LIGHT_GRAY);
        button_neustart.setFocusable(false);
        button_neustart.setFont(new Font("Arial", Font.BOLD,15));
        button_neustart.addActionListener(this);



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
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("Arial", Font.BOLD,15));



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(380, 400);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.darkGray);

        //frame.add(text);
        frame.add(button_neustart);
        frame.add(Spieler_gewonnen);
        frame.add(close_button);

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
        } else if (Spielfeld[6] == z && Spielfeld[7] == z && Spielfeld[8] == z) {
            return  Spieler;
        } else if (Spielfeld[0] == z && Spielfeld[3] == z && Spielfeld[6] == z) {
            return  Spieler;
        } else if (Spielfeld[1] == z && Spielfeld[4] == z && Spielfeld[7] == z) {
            return  Spieler;
        } else if (Spielfeld[2] == z && Spielfeld[5] == z && Spielfeld[8] == z) {
            return  Spieler;
        } else if (Spielfeld[0] == z && Spielfeld[4] == z && Spielfeld[8] == z) {
            return  Spieler;
        } else if (Spielfeld[2] == z && Spielfeld[4] == z && Spielfeld[6] == z) {
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

        if(e.getSource() == close_button) {
            frame.dispose();
        }


        if(e.getSource() == button_neustart) {
            Spieler_Zug = true;
            Zuege_Count = 0;
            text.setText(" ");
            for(int y = 0; y < 9; y++) {
                Feld_besetzt[y] = false;
                Spielfeld[y] = 'a';
                buttons[y].setText("");
                buttons[y].setEnabled(true);
            }
        }


        if(Spieler_Zug) {
            for(int i = 0; i < 9; i++) {
                if(e.getSource() == buttons[i] && !Feld_besetzt[i]) {
                    buttons[i].setText("X");
                    buttons[i].setFont(new Font("Arial", Font.BOLD,22));
                    buttons[i].setForeground(Color.BLUE);
                    Spielfeld[i] = 'X';
                    Spieler_Zug = false;
                    Feld_besetzt[i] = true;
                    Zuege_Count++;

                    if(Check_gewonnen(Spielfeld, 1) == 1) {
                        text.setText("GEWONNEN");
                        Spieler_win_counter++;
                        for(int x = 0; x < 9; x++) {
                            buttons[x].setEnabled(false);
                        }

                    }  else if (Zuege_Count == 9 && Check_gewonnen(Spielfeld, 1) == 3) {
                        text.setText("Unentschieden");

                    }

                }

            }

        }

        if(!Spieler_Zug && Zuege_Count != 9 && Check_gewonnen(Spielfeld, 2) != 1) {
            int Computer_Zug;
            Random rand = new Random();

            do {
                Computer_Zug = rand.nextInt(9);
            } while (Feld_besetzt[Computer_Zug]);


            buttons[Computer_Zug].setText("O");
            Spielfeld[Computer_Zug] = 'O';
            buttons[Computer_Zug].setFont(new Font("Arial", Font.BOLD,21));
            buttons[Computer_Zug].setForeground(Color.RED);
            Spieler_Zug = true;
            Feld_besetzt[Computer_Zug] = true;
            Zuege_Count++;

            if (Check_gewonnen(Spielfeld, 2) == 2) {
                text.setText("VERLOREN");
                Computer_win_counter++;
                for(int x = 0; x < 9; x++) {
                    buttons[x].setEnabled(false);
                }
            } else if (Zuege_Count == 9 && Check_gewonnen(Spielfeld, 2) == 3) {
                text.setText("Unentschieden");

            }

        }

        Spieler_gewonnen.setText("Du : " + Spieler_win_counter + "  |  " + Computer_win_counter + " : Computer");

    }

}
