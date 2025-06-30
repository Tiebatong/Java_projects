import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

    private JFrame frame;
    private JLabel label;
    private JTextField input;
    private JButton button2;
    private JButton button1;
    private int width;
    private int height;

    public GUI(int w, int h)
    {
        frame = new JFrame();
        label = new JLabel("Hello");
        input = new JTextField(10);
        button1 = new JButton("Button1");
        button2 = new JButton("Button2");
        width = w;
        height = h;

    }

    public void setupGUI(){
        Container cp = frame.getContentPane();
        FlowLayout flow = new FlowLayout();
        cp.setLayout(flow);
        frame.setSize(width,height);
        frame.setTitle("GUI Demo");
        cp.add(input);
        cp.add(label);
        cp.add(button1);
        cp.add(button2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setUpButtonListeners()
    {
        ActionListener buttonlistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("clicked!");
            }
        };
        ActionListener buttonlistener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("button2 pressed");
            }
        };
        button1.addActionListener(buttonlistener);
        button2.addActionListener(buttonlistener2);
        }

    }

