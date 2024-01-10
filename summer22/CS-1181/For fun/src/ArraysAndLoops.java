import java.util.ArrayList;

public class ArraysAndLoops {
    
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> checkoutLanes = new ArrayList<>();
        int numOfLanes = 8;
        
        for (int i = 1; i < numOfLanes + 1; i++) {
            checkoutLanes.add(i);
        }

        for (int j = 0; j < checkoutLanes.size(); j++) {
            System.out.println("Checkout lane #" + checkoutLanes.get(j));
            // Thread.sleep(1000);
        }
    }
}
