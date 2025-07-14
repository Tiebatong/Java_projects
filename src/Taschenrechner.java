import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Taschenrechner implements ActionListener {

    JFrame frame;
    JButton[] number_buttons;
    JButton add_button;
    JButton minus_button;
    JButton divide_button;
    JButton mult_button;
    JButton equal_button;
    JButton clear_button;
    JButton delete_button;
    JTextField textField;

    float result = 0;
    float num1 = 0;
    float num2 = 0;
    char operator = 'n';

    public Taschenrechner() {

        number_buttons = new JButton[10];

        add_button = new JButton();
        add_button.setText("+");
        add_button.addActionListener(this);
        add_button.setFocusable(false);

        minus_button = new JButton();
        minus_button.setText("-");
        minus_button.addActionListener(this);
        minus_button.setFocusable(false);

        divide_button = new JButton();
        divide_button.setText("/");
        divide_button.addActionListener(this);
        divide_button.setFocusable(false);

        mult_button = new JButton();
        mult_button.setText("*");
        mult_button.addActionListener(this);
        mult_button.setFocusable(false);

        equal_button = new JButton();
        equal_button.setText("=");
        equal_button.addActionListener(this);
        equal_button.setFocusable(false);

        clear_button = new JButton();
        clear_button.setText("clear");
        clear_button.addActionListener(this);
        clear_button.setFocusable(false);

        delete_button = new JButton();
        delete_button.setText("delete");
        delete_button.addActionListener(this);
        delete_button.setFocusable(false);


        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(100, 30, 270, 50);

         frame = new JFrame();

        for(int i = 0; i < 10; i++) {


            number_buttons[i] = new JButton();
            number_buttons[i].setFocusable(false);
            number_buttons[i].addActionListener(this);
            number_buttons[i].setText("" + i);
            frame.add(number_buttons[i]);
        }

        int breite = 60;
        int hoehe = 60;

        number_buttons[1].setBounds(100, 100, breite, hoehe);
        number_buttons[2].setBounds(170, 100, breite, hoehe);
        number_buttons[3].setBounds(240, 100, breite, hoehe);
        number_buttons[4].setBounds(100, 170, breite, hoehe);
        number_buttons[5].setBounds(170, 170, breite, hoehe);
        number_buttons[6].setBounds(240, 170, breite, hoehe);
        number_buttons[7].setBounds(100, 240, breite, hoehe);
        number_buttons[8].setBounds(170, 240, breite, hoehe);
        number_buttons[9].setBounds(240, 240, breite, hoehe);
        number_buttons[0].setBounds(170, 310, breite, hoehe);

        add_button.setBounds(310, 100, breite, hoehe);
        minus_button.setBounds(310, 170, breite, hoehe);
        divide_button.setBounds(310, 240, breite, hoehe);
        mult_button.setBounds(310, 310, breite, hoehe);
        equal_button.setBounds(240, 310, breite, hoehe);
        clear_button.setBounds(100, 380, 130, hoehe);
        delete_button.setBounds(240, 380, 130, hoehe);


        frame.setSize(500, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(textField);
        frame.add(add_button);
        frame.add(minus_button);
        frame.add(divide_button);
        frame.add(mult_button);
        frame.add(equal_button);
        frame.add(clear_button);
        frame.add(delete_button);
        frame.setVisible(true);

    }
    public static void main(String[] args ) {
        new Taschenrechner();
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        for(int i = 0; i < 10; i++) {
            if(e.getSource() == number_buttons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
                System.out.println(i);
            }
        }
        if(e.getSource() == clear_button) {
            textField.setText("");
        }
        if(e.getSource() == delete_button) {
            String zwischen = textField.getText();
            textField.setText("");
            for(int x = 0; x < (zwischen.length() -  1); x++) {
                textField.setText(textField.getText() + zwischen.charAt(x));
            }
        }

        if(e.getSource() == add_button) {
            num1 = Float.parseFloat(textField.getText());
            textField.setText("");
            operator = '+';
        } else if (e.getSource() == minus_button) {
            num1 = Float.parseFloat(textField.getText());
            textField.setText("");
            operator = '-';
        } else if (e.getSource() == divide_button) {
            num1 = Float.parseFloat(textField.getText());
            textField.setText("");
            operator = '/';
        } else if (e.getSource() == mult_button) {
            num1 = Float.parseFloat(textField.getText());
            textField.setText("");
            operator = '*';
        }

        if(e.getSource() == equal_button) {
            num2 = Float.parseFloat(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
            }
            textField.setText("" + result);
        }
    }
}
