package ProjectTwo;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MemoryGameRoughDraft2 {

    public MemoryGameRoughDraft2() {

        JFrame gameFrame = new JFrame();
        gameFrame.setTitle("Memory Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setSize(1000, 750);
        gameFrame.setVisible(true);
        gameFrame.setLayout(null);

        JLabel directionsLabel = new JLabel();
        directionsLabel.setText("Directions:");        

        JPanel directionsPanel = new JPanel();
        directionsPanel.setBounds(0, 0, 250, 250);
        directionsPanel.setBackground(Color.blue);
        directionsPanel.add(directionsLabel);
        gameFrame.add(directionsPanel);
    }
    public static void main(String[] args) {

        new MemoryGameRoughDraft2();
    }
}
