package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.GridLayout;

public class ImageIcon extends JFrame {
    
    public ImageIcon() {
        initComponents();
    }

    private void initComponents() {
        setTitle("ImageIcon");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(2, 3));

        javax.swing.ImageIcon img = new javax.swing.ImageIcon("C:\\Users\\cszok\\VS sync files\\VS Code\\CS-1181\\Lecture\\src\\GUI\\triangle.png");

        JButton b1 = new JButton(img);
        b1.setActionCommand("Triangle 1");
        JButton b2 = new JButton(img);
        b2.setActionCommand("Triangle 2");
        JButton b3 = new JButton(img);
        b3.setActionCommand("Triangle 3");
        JButton b4 = new JButton(img);
        b4.setActionCommand("Triangle 4");
        JButton b5 = new JButton(img);
        b5.setActionCommand("Triangle 5");

        JLabel l = new JLabel("Choose a triangle");

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);

        add(l);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                l.setText("You selected " + ae.getActionCommand());
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                l.setText("You selected " + ae.getActionCommand());
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                l.setText("You selected " + ae.getActionCommand());
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                l.setText("You selected " + ae.getActionCommand());
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                l.setText("You selected " + ae.getActionCommand());
            }
        });

        pack(); //call
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {   
                new ImageIcon();             
            }
            
        });
    }
}
