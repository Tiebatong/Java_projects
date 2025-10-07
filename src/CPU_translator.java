import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPU_translator implements ActionListener {


    JFrame frame;
    JButton[] Bits = new JButton[9];
    JButton reset;
    JTextField textField;
    JTextField textField_mode;
    String[] modes = new String[4];
    int[] values = new int[8];
    int value;
    int mode_value;

    public CPU_translator(){

        frame = new JFrame();

        int width = 50;
        int height = 50;
        int x_cord = 100;
        int y_cord = 100;



        int Byte = 8;

        for(int i = 0; i <= Byte; i++) {

            Bits[i] = new JButton();
            Bits[i].setBounds(x_cord, y_cord, width, height);
            x_cord += 55;
            Bits[i].setVisible(true);
            Bits[i].addActionListener(this);
            Bits[i].setText("0");
            Bits[i].setFocusable(false);

            frame.add(Bits[i]);

        }
        System.out.println(x_cord);

        reset = new JButton("reset");
        reset.setBounds(550, y_cord, 100, 50);
        reset.setFocusable(false);
        reset.addActionListener(this);


        modes[0] = "Bus_to_Reg_0";
        modes[1] = "Reg_to_Reg";
        modes[2] = "ALU";
        modes[3] = "Comparator";


        textField = new JTextField();
        textField.setBounds(250, 200, 200,50);
        textField.setEditable(false);
        textField.setText("DEC: ");


        textField_mode = new JTextField();
        textField_mode.setBounds(250, 260, 200, 50);
        textField_mode.setEditable(false);
        textField_mode.setText(modes[0]);


        frame.setVisible(true);
        frame.setTitle("Translator");
        frame.setBounds(0,0,800,500);
        frame.setLayout(null);
        frame.add(textField);
        frame.add(textField_mode);
        frame.add(reset);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        int start = 64;
        values[0] = -128;

        for (int i = 1; i < 8; i++) {
            values[i] = start;
            start /= 2;
        }



    }


    public static void main(String[] args) {

        CPU_translator translator = new CPU_translator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        for (int i = 0; i < 8; i++) {
            if (e.getSource() == Bits[i] && Bits[i].getText() == "0") {
                Bits[i].setText("1");
                value = value + values[i];
            } else if (e.getSource() == Bits[i] && Bits[i].getText() == "1") {
                Bits[i].setText("0");
                value = value - values[i];
            }
        }
        textField.setText("DEC: " + value);


        mode_value = values[0] * Integer.parseInt(Bits[0].getText()) + values[1] * Integer.parseInt(Bits[1].getText());

        if (mode_value == 0) {
            textField_mode.setText(modes[0]);
        } else if (mode_value == 64) {
            textField_mode.setText(modes[1]);
        } else if (mode_value == -128) {
            textField_mode.setText(modes[2]);
        } else if (mode_value == -64) {
            textField_mode.setText(modes[3]);
        }

        if (e.getSource() == reset) {
            value = 0;
            for (int i = 0; i < 8; i++) {
                Bits[i].setText("0");
            }
        }
    }
}
