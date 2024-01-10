package five;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CheckDivider extends JFrame {

    private JButton calculate;
    private JTextField total;
    private JTextField tipPercentage;
    private JTextField numberOfPeople;
    private JTextField eachPersonPays;

    public CheckDivider() {
        super ("Check Divider");

        JPanel totalPanel = new JPanel();
        totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.Y_AXIS));

        JLabel totalLabel = new JLabel("Total:");
        total = new JTextField(10);
        totalPanel.add(totalLabel);
        totalPanel.add(total);
        totalLabel.setFont(new Font("Calibri", Font.PLAIN, 20));

        JPanel tpPanel = new JPanel();
        tpPanel.setLayout(new BoxLayout(tpPanel, BoxLayout.Y_AXIS));

        JLabel tpLabel = new JLabel("Tip Percentage:");
        tipPercentage = new JTextField(10);
        totalPanel.add(tpLabel);
        totalPanel.add(tipPercentage);
        tpLabel.setFont(new Font("Calibri", Font.PLAIN, 20));

        JPanel numPanel = new JPanel();
        numPanel.setLayout(new BoxLayout(numPanel, BoxLayout.Y_AXIS));

        JLabel numLabel = new JLabel("Number of People:");
        numberOfPeople = new JTextField(10);
        numPanel.add(numLabel);
        numPanel.add(numberOfPeople);
        numLabel.setFont(new Font("Calibri", Font.PLAIN, 20));

        JPanel eppPanel = new JPanel();
        eppPanel.setLayout(new BoxLayout(eppPanel, BoxLayout.Y_AXIS));
        eppPanel.setBorder(BorderFactory.createEmptyBorder());

        JLabel eppLabel = new JLabel("Each person pays:");
        eachPersonPays = new JTextField(10);
        eppPanel.add(eppLabel);
        eppPanel.add(eachPersonPays);
        eppLabel.setFont(new Font("Calibri", Font.PLAIN, 20));

        calculate = new JButton("Calculate");
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    double totalAmount = Double.parseDouble(total.getText().trim());
                    int tipPercentageAmount = Integer.parseInt(tipPercentage.getText().trim());
                    int numberOfPeopleAmount = Integer.parseInt(numberOfPeople.getText().trim());
                    double eachPersonPaysAmount = (totalAmount + (totalAmount * tipPercentageAmount)) / numberOfPeopleAmount;
                    eachPersonPays.setText("$" + eachPersonPaysAmount%2.f);
                } catch (Exception ex) {
                    eachPersonPays.setText("");
                    ex.printStackTrace();;
                }
            }
        });

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(totalPanel);
        contentPanel.add(tpPanel);
        contentPanel.add(numPanel);
        contentPanel.add(eppPanel);
        contentPanel.add(calculate);
        

        contentPanel.setBounds(0, 0, 500, 375);

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
                new CheckDivider();
            }
        });
    }
}
