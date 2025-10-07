import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPU_translator implements ActionListener {


    JFrame frame;
    JButton[] Bits;

    public CPU_translator(){

        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Translator");
        frame.setBounds(0,0,500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        int width = 50;
        int height = 50;
        int x_cord = 10;
        int y_cord = 10;

        int Byte = 8;
        for(int i = 0; i < Byte; i++) {
            Bits[i] = new JButton();
            Bits[i].setBounds(x_cord, y_cord, width, height);

        }



    }


    public static void main(String[] args) {

        CPU_translator translator = new CPU_translator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
