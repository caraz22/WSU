package SamProjects.Valentine;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Valentine {

    JFrame frame = new JFrame();
    JPanel questionPanel = new JPanel();
    JPanel yesPanel = new JPanel();
    JPanel noPanel = new JPanel();
    JButton yesButton = new JButton("Yes! <3");
    JButton noButton = new JButton("No... :(");
    CardLayout cL = new CardLayout();
    JPanel cardPanel = new JPanel();
    Icon snoopy = new ImageIcon("Cara//src//SamProjects//Valentine//images//snoopy-valentine.jpg");
    JLabel imageHolder = new JLabel();

    Valentine() {
        
        frame.setTitle("Valentine");
        frame.setSize(736, 1000);
        frame.setResizable(false);

        cardPanel.setLayout(cL);
        cardPanel.add(questionPanel, "1");
        cardPanel.add(yesPanel, "2");
        cardPanel.add(noPanel, "3");

        imageHolder.setBounds(0, 0, 736, 1000);
        imageHolder.setIcon(snoopy);
        questionPanel.add(imageHolder);
        questionPanel.setLayout(null);

        frame.add(cardPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        new Valentine();
    }
}