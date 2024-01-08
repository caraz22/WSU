package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class SwingTimer {
    
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                count++;
                System.out.println("timer fired, count: " + count);
            }
        };

        Timer timer = new Timer(1000, taskPerformer);
        timer.setInitialDelay(2000);
        timer.setRepeats(true);
        timer.start();

        Thread.sleep(6000);
    }
}
