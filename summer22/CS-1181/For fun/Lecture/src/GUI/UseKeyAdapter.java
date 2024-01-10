package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UseKeyAdapter extends JFrame {

    private JButton b1;
    private JTextField tf;

    public UseKeyAdapter() {
        initComponents();
    }

    private void initComponents() {
        setTitle("UseKeyAdapter");
        setBounds(0, 0, 800, 600);

        b1 = new JButton("click me");
        b1.setFont(new Font("Calibri", Font.PLAIN, 40));

        tf = new JTextField(10);
        tf.setFont(new Font("Calibri", Font.PLAIN, 40));

        add(b1, BorderLayout.CENTER);
        add(tf, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Button was clicked.");
                
            }
        });

        tf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                System.out.println("key typed");
            }
        });

        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.out.println("key pressed");
            }
        });
    }
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UseKeyAdapter().setVisible(true);
            }
        });
    }
}
