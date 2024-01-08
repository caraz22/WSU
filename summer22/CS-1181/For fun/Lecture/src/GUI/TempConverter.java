package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TempConverter extends JFrame {

    private JTextField fTF;
    private JTextField cTF;
    private JTextField lastEdited;

    public TempConverter() {
        super("Temperature converter");

        JPanel fPanel = new JPanel();
        fPanel.setLayout(new BoxLayout(fPanel, BoxLayout.Y_AXIS));

        JLabel fLabel = new JLabel("Fahrenheit");
        fTF = new JTextField(10);
        fPanel.add(fLabel);
        fPanel.add(fTF);

        fTF.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                lastEdited = (JTextField) e.getSource();
            }
        });

        JPanel cPanel = new JPanel();
        cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));

        JLabel cLabel = new JLabel("Celsius");
        cTF = new JTextField(10);
        cPanel.add(cLabel);
        cPanel.add(cTF);

        cTF.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                lastEdited = (JTextField) e.getSource();
            }
        });

        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.X_AXIS));
        dataPanel.add(fPanel);
        dataPanel.add(cPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton convert = new JButton("Convert");
        buttonPanel.add(convert);

        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                if (lastEdited == fTF) {
                    double fTemp = Double.parseDouble(fTF.getText().trim());
                    double cTemp = (fTemp - 32) * 5.0 / 9;
                    cTF.setText("" + cTemp);
                } else {
                    double cTemp = Double.parseDouble(cTF.getText().trim());
                    double fTemp = (cTemp * 9.0 / 5) + 32;
                    fTF.setText("" + fTemp);
                }
                } catch (Exception ex) {
                    lastEdited.setText("");
                    ex.printStackTrace();
                }
            }
        });

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(dataPanel);
        contentPanel.add(buttonPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPanel);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TempConverter();
            }    
        });
    }
}
