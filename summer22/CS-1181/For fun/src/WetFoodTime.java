import java.util.ArrayList;

public class WetFoodTime {
    
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> clock = new ArrayList<>();

        Cat Midna = new Cat("Midna");
        Cat Ren = new Cat("Ren");

        for (int i = 1; i < 25; i++) {
            clock.add(i);
        }

        for (int j = 0; j < clock.size(); j++) {
            if (clock.get(j) == 16) {
                System.out.println("*cracks open wet food* It's 16 o'clock!");
                System.out.println("Midna is " + Midna.getMidnaStatus(clock.get(j)));
                System.out.println("Ren is " + Ren.getRenStatus(clock.get(j)));
            } else {
                System.out.println("It is " + clock.get(j) + " o'clock.");
                System.out.println("What is Midna doing? " + Midna.getMidnaStatus(clock.get(j)));
                System.out.println("What is Ren doing? " + Ren.getRenStatus(clock.get(j)));                
            }

            Thread.sleep(5000);
        }
    }
}
