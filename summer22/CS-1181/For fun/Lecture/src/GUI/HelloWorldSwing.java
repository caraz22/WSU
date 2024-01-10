package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HelloWorldSwing {

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    
    public static void main(String[] args) {

        // SwingUtilities.invokeLater(new myGUI());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // static class myGUI implements Runnable {

    //     @Override
    //     public void run() {
    //         createAndShowGUI();
    //     }
    // }
}