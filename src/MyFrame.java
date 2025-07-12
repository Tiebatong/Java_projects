import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JLabel label;

    MyFrame() {


        button = new JButton();

        button.setBounds(150, 150, 250, 100);
        button.addActionListener(this);
        button.setText("Click here");
        button.setFocusable(false);
        button.setFont(new Font("Comoc Sans",Font.BOLD, 25));
        button.setForeground(Color.GRAY);
        button.setBackground(Color.DARK_GRAY);

        label = new JLabel();
        label.setBounds(150, 250, 150, 150);
        label.setVisible(false);




        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            System.out.println("Button pressed");


        }
    }
}
