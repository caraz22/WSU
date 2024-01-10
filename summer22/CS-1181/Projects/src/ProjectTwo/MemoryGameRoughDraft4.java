package ProjectTwo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class MemoryGameRoughDraft4 {

    JFrame gameFrame = new JFrame();
    JPanel directionsPanel = new JPanel();
    JPanel startPanel = new JPanel();
    JPanel responsePanel = new JPanel();
    JLabel directionsLabel = new JLabel();
    JButton directionsButton = new JButton("Directions");
    JOptionPane directions = new JOptionPane();
    JButton start = new JButton("Start");
    JLabel levelLabel = new JLabel();
    JTable scores = new JTable();
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");

    MemoryGameRoughDraft4() {

        gameFrame.setTitle("Memory Game");
        gameFrame.setSize(1000, 750);
        gameFrame.setLayout(null);
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startPanel.setLayout(null);
        startPanel.setBounds(0, 0, 500, 400);
        startPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        start.setFont(new Font("Courier New", Font.PLAIN, 40));
        start.setFocusable(false);
        start.setSize(200, 125);
        start.setLocation(150, 125);
        startPanel.add(start);

        directionsPanel.setLayout(null);
        directionsPanel.setBounds(500, 0, 500, 400);
        directionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        directionsButton.setFont(new Font("Courier New", Font.PLAIN, 25));
        directionsButton.setFocusable(false);
        directionsButton.setSize(200, 125);
        directionsButton.setLocation(150, 125);
        directionsPanel.add(directionsButton);

        responsePanel.setLayout(new GridLayout());
        responsePanel.setBounds(0, 350, 1000, 365);
        responsePanel.setBackground(Color.white);
        responsePanel.add(one);
        responsePanel.add(two);
        responsePanel.add(three);
        responsePanel.add(four);
        responsePanel.add(five);

        one.setFocusable(false);
        one.setFont(new Font("Courier New", Font.PLAIN, 50));

        two.setFocusable(false);
        two.setFont(new Font("Courier New", Font.PLAIN, 50));

        three.setFocusable(false);
        three.setFont(new Font("Courier New", Font.PLAIN, 50));

        four.setFocusable(false);
        four.setFont(new Font("Courier New", Font.PLAIN, 50));

        five.setFocusable(false);
        five.setFont(new Font("Courier New", Font.PLAIN, 50));

        gameFrame.add(directionsPanel);
        gameFrame.add(startPanel);
        gameFrame.setVisible(true);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.remove(directionsPanel);
            }
        });
    }


    public static void main(String[] args) {

        new MemoryGameRoughDraft4();
    }
}
