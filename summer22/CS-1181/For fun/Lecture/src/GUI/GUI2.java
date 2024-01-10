package GUI;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GUI2 extends JFrame {

    private JButton b1;

    public GUI2() {
        super("My GUI2");
        initComponents();
    }    

    private void initComponents() {
        setBounds(0, 0, 800, 600); //avoid

        b1 = new JButton("click me");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        add(b1); //layout management
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI2();
            }
        });
    }
}
