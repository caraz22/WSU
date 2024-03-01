package GUI;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.GridLayout;

public class GUIJPanelBorder extends JFrame {

    private static final long serialVersionUID = 1L;

    private JButton b;
    private JTextArea ta;

    public GUIJPanelBorder() {
        initComponents();
    }

    private void initComponents() {
        setTitle("GUI with empty border and some other components");
        int width = 20;

        b = new JButton("click me");
        ta = new JTextArea("Edit this");

        b.setFont(new Font("Helvetica Neue", Font.PLAIN, 40));
        ta.setFont(new Font("Helvetica Neue", Font.PLAIN, 40));

        JPanel p = new JPanel();

        p.setBorder(BorderFactory.createEmptyBorder(width, width, width, width));
        p.setLayout(new GridLayout(2, 1));
        p.add(b);
        p.add(ta);

        setContentPane(p);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        b.addActionListener(new ButtonEventHandler());
        System.out.println("The thread where we create GUI: " + Thread.currentThread().getName());
    }
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIJPanelBorder().setVisible(true);
            }
        });
    }
}

class ButtonEventHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Button was clicked at: " + ae.getSource());
        System.out.println("The thread of GUI is: " + Thread.currentThread().getName());
    }
}
