package GUI;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;


public class GUIwithUserInteraction extends JFrame {

    private JButton b;
    private JTextArea ta;

    public GUIwithUserInteraction() {
        initComponents();
    }

    private void initComponents() {
        b = new JButton("click me");
        ta = new JTextArea("Edit this");

        b.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        ta.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        setLayout(new GridLayout(2, 1)); //2x1 grid

        add(b);
        add(ta);

        setBounds(10, 10, 800, 600);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                ta.append("\nButton was clicked at: " + new Date());
                System.out.println("Button was clicked.");
            }
        });

        // class ButtonEventHandler implements ActionListener {

        //     @Override
        //     public void actionPerformed(ActionEvent ae) {

                // ta.append("\nButton was clicked at: " + new Date());
        //         System.out.println("Button was clicked.");                
        //     }
        // } 
        // b.addActionListener(new ButtonEventHandler());
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIwithUserInteraction().setVisible(true);
            }
        });
    }
}
