package ProjectTwo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MemoryGameRoughDraft3 {

    // private JButton one;
    // private JButton two;
    // private JButton three;
    // private JButton four;
    // private JButton five;
    private JButton start;

    public MemoryGameRoughDraft3() {

        JFrame gameFrame = new JFrame();
        gameFrame.setTitle("Memory Game");
        gameFrame.setSize(1000, 750);
        gameFrame.setLayout(null);

        JLabel directionsLabel = new JLabel();
        directionsLabel.setText("Directions:");
        directionsLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
        directionsLabel.setBounds(625, 50, 100, 50);
        
        JTextArea directions = new JTextArea("This is a number memory game. \nNumbers 1 through 5 will be presented one at a time on the screen. \nYou must remember the order of the numbers as they were presented. \nWhen they are done being presented, you must click the numbers at the bottom in the correct order. \nEach level will add one number to the sequence, with level 1 starting with only one number. \nYour goal is to get through as many levels as possible.");
        directions.setFont(new Font("Courier New", Font.PLAIN, 16));
        directions.setLineWrap(true);
        directions.setWrapStyleWord(true);
        directions.setEditable(false);
        directions.setBounds(625, 100, 400, 300);

        JPanel directionsPanel = new JPanel();
        directionsPanel.setLayout(null);         
        directionsPanel.setBounds(500, 0, 500, 400);
        directionsPanel.add(directionsLabel);
        directionsPanel.setBackground(Color.pink);
        directionsPanel.add(directions);


        gameFrame.add(directionsPanel);

        JPanel startPanel = new JPanel();
        startPanel.setBounds(0, 0, 500, 400);
        startPanel.setBackground(Color.white);
        startPanel.setLayout(new GridBagLayout());

        start = new JButton("Start");
        start.setHorizontalAlignment(JButton.CENTER);
        start.setVerticalAlignment(JButton.CENTER);
        start.setFont(new Font("Courier New", Font.PLAIN, 40));
        start.setFocusable(false);
        start.setBorder(BorderFactory.createEtchedBorder());
        start.setSize(200, 100);

        startPanel.add(start);
        gameFrame.add(startPanel);        

        gameFrame.setResizable(false);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        new MemoryGameRoughDraft3();
    }
}
