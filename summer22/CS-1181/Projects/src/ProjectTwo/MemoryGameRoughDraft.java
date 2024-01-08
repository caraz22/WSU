package ProjectTwo;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MemoryGameRoughDraft extends JFrame {
    
    private JButton start;
    private JButton directions;
    private JTextArea textArea;

    public MemoryGameRoughDraft() {
        super("Memory game");
        initComponents();
    }

    public void initComponents() {
        start = new JButton("Start");
        directions = new JButton("Directions");
        textArea = new JTextArea("");

        start.setFont(new Font("Courier New", Font.PLAIN, 40));
        directions.setFont(new Font("Courier New", Font.PLAIN, 40));
        textArea.setFont(new Font("Courier New", Font.PLAIN, 20));

        setLayout(new GridLayout(2, 1));

        add(start);
        add(directions);
        add(textArea);

        setBounds(15, 15, 1000, 800);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent starting) {
                textArea.append("The numbers you've selected will be shown here.");
                
            }
        });

        directions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent viewDirections) {
                textArea.append("Directions: \nThere will be numbers presented for a short time in a certain order, \nEach level will add a number, with level 1 starting with one number, \nYour goal is to get through as many levels as you can.");      
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MemoryGameRoughDraft().setVisible(true);
            }
        });
    }
}
