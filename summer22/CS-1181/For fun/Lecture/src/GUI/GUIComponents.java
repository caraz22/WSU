package GUI;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.awt.Font;

import java.awt.GridLayout;

public class GUIComponents {

    private void initComponents() {
        JFrame jf = new JFrame("GUI components");

        jf.setLayout(new GridLayout(2, 2));

        JButton b = new JButton("Click me");
        JTextArea ta = new JTextArea("Edit this");

        b.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        ta.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        JPanel p = new JPanel();

        JRadioButton rb1 = new JRadioButton("English", true); //select this button
        JRadioButton rb2 = new JRadioButton("Spanish", false);
        JRadioButton rb3 = new JRadioButton("Deutsch", false);
        rb1.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        rb2.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        rb3.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);

        p.setLayout(new GridLayout(3, 1));
        p.add(rb1);
        p.add(rb2);
        p.add(rb3);

        String[] labels = {"Alex", "Chris", "Grant"};
        JList<String> l = new JList<>(labels);
        l.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        jf.add(b);
        jf.add(ta);
        jf.add(p);
        jf.add(l);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBounds(10, 10, 800, 600);
        jf.setVisible(true);
    }
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIComponents().initComponents();
            }
        });
    }
}
