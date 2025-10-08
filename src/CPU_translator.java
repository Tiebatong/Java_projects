import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPU_translator implements ActionListener {


    JFrame frame;
    JButton[] Bits = new JButton[9];
    JButton reset;
    JTextField textField;
    JTextField textField_mode;
    JTextField TF_operation;
    JTextField TF_Hex;
    String[] modes = new String[4];
    String[] comp_modes = new String[6];
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


        reset = new JButton("reset");
        reset.setBounds(550, y_cord, 100, 50);
        reset.setFocusable(false);
        reset.addActionListener(this);


        modes[0] = "Bus_to_Reg_0";
        modes[1] = "Reg_to_Reg";
        modes[2] = "ALU";
        modes[3] = "Comparator";

        comp_modes[0] = ">0";
        comp_modes[1] = "<0";
        comp_modes[2] = ">=0";
        comp_modes[3] = "<=0";
        comp_modes[4] = "==0";
        comp_modes[5] = "!=0";


        textField = new JTextField();
        textField.setBounds(250, 200, 200,50);
        textField.setEditable(false);
        textField.setText("DEC: ");


        textField_mode = new JTextField();
        textField_mode.setBounds(250, 260, 200, 50);
        textField_mode.setEditable(false);
        textField_mode.setText(modes[0]);


        TF_operation = new JTextField();
        TF_operation.setBounds(250, 320,200,50);
        TF_operation.setEditable(false);
        TF_operation.setText("write 0 to Reg_0");


        TF_Hex = new JTextField();
        TF_Hex.setBounds(250, 380, 200,50);
        TF_Hex.setEditable(false);


        frame.setVisible(true);
        frame.setTitle("Translator");
        frame.setBounds(0,0,800,500);
        frame.setLayout(null);
        frame.add(textField);
        frame.add(textField_mode);
        frame.add(TF_operation);
        frame.add(TF_Hex);
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


        if (e.getSource() == reset) {
            value = 0;
            for (int i = 0; i < 8; i++) {
                Bits[i].setText("0");
            }
        }

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
        TF_Hex.setText("HEX: " + hex(value));


        mode_value = values[0] * Integer.parseInt(Bits[0].getText()) + values[1] * Integer.parseInt(Bits[1].getText());

        switch (mode_value) {

            case 0: // BUS to REG_0
                textField_mode.setText(modes[0]);
                TF_operation.setText("write " + value + " to Reg_0");
                break;
            case 64: // REG_x to REG_x
                textField_mode.setText(modes[1]);
                int write_address = 0;
                for (int i = 5; i < 8; i++) {
                    if (Bits[i].getText() == "1") {
                        write_address += values[i];
                    }
                }
                int read_address = 0;
                int j = 5;
                for (int i = 2; i < 5; i++) {
                    if (Bits[i].getText() == "1") {
                        read_address += values[j];
                    }
                    j++;
                }
                TF_operation.setText("write Reg_" + write_address + " to Reg_" + read_address);
                break;
            case -128: // ALU
                String sub_mode;
                boolean add = false;
                if (Bits[2].getText() == "1") {
                    sub_mode = "SUB";
                } else {
                    sub_mode = "ADD";
                    add = true;
                }
                textField_mode.setText(modes[2] + " " + sub_mode);
                write_address = 0;

                for (int i = 5; i < 8; i++) {
                    if (Bits[i].getText() == "1") {
                        write_address += values[i];
                    }
                }

                if (add) {
                    TF_operation.setText("save Reg_1 + Reg_2 to Reg_" + write_address);
                } else {
                    TF_operation.setText("save Reg_1 - Reg_2 to Reg_" + write_address);
                }

                break;
            case -64: // COMPARATOR
                textField_mode.setText(modes[3]);
                read_address = 0;
                j = 5;
                for (int i = 2; i < 5; i++) {
                    if (Bits[i].getText() == "1") {
                        read_address += values[j];
                    }
                    j++;
                }

                String stop_timer = "";
                if (Bits[7].getText() == "1") {
                    stop_timer = " if true stop_timer";
                }

                TF_operation.setText("comp Reg_2 " + comp_modes[read_address] + stop_timer);



                break;
        }





    }

    public static String hex(int x) {
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        char[] hex = {' ', ' '}; // 2 digits only

        StringBuilder sb = new StringBuilder();

        if ( x < 0) {
            int y = 128;
            int[] bin_digits = new int[8];
            for (int i = 0 ; i < 8; i++) { // create array with binary values: 128, 64, 32...
                bin_digits[i] = y;
                y /= 2;
            }
            x *= -1;
            int counter = 7;
            int[] binary_arr = new int[8];
            while (x > 0) {
                binary_arr[counter] = x % 2; // convert to binary
                x /= 2;
                counter--;
            }
            int twos_complement = 0;

            // twos complement, flip all bits
            for (int i = 0; i < 8; i++) {
                if (binary_arr[i] == 1) {
                    binary_arr[i] = 0;
                } else {
                    binary_arr[i] = 1;
                }
            }
            boolean one_added = false;
            //boolean leading_one = false;
            int index = 7;
            int step_counter = 0;
            while (!one_added) {
                if (binary_arr[index] == 0) {
                    binary_arr[index] = 1;
                    for (int i = 0; i < step_counter; i++) {
                        binary_arr[i] = 0;
                    }
                } else {
                    step_counter++;
                }
            }

            for (int i = 0; i < 8; i++) {
                twos_complement += digits[i]; // converts binary to decimal
            }
            x = twos_complement;


        }

        int j = 1;
        while (x > 0) {
            int tmp = x % 16; // convert to hex
            hex[j] = digits[tmp];
            x /= 16;
            j--;
        }
        sb.append(hex[0]);
        sb.append(hex[1]);

        System.out.println(sb);
        String hexa = sb.toString();

        return hexa;
    }

}
