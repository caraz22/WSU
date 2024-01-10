import java.util.ArrayList;
import java.util.Collections;

class Driver {

    public static Clock createRandomClock() {
        int hours = (int) (Math.random() * 24);
        int mins = (int) (Math.random() * 60);
        int secs = (int) (Math.random() * 60);
        return new Clock(hours, mins, secs);
    }

    public static void main(String[] args) throws Exception {

        Clock.setSeparator(':');
        ArrayList<Clock> clocks = new ArrayList<>();

        for (int i=1; i<=5; i++) {
            //clocks.add(new Clock(i, 0, 0));
            clocks.add(createRandomClock());
        }

        System.out.println(clocks);
        Collections.sort(clocks);
        System.out.println(clocks);

        /*
        Clock test = new Clock(5, 0, 0);
        if (clocks.contains(test)) {
            System.out.println("yay");
        } else {
            System.out.println("boo");
        }
        */

        /*
        while (true) {
            Thread.sleep(2000);
            for (Clock clock: clocks) {
                clock.tick();
                System.out.println(clock);
            }
        }
        */

        /*
        Clock c1 = new Clock(12, 0, 0);
        Clock c2 = new Clock (23, 30, 0);
        Clock.setSeparator('-');
        
        int currHour = c1.getHours();
        if (currHour == 17) {
            System.out.println("Dinner time!");
        }
        
        System.out.println("c1 = " + c1.toString());
        System.out.println("c2 = " + c2); //both c2 and c2.toString() will work
    
        //DST happens
        //c1.hours = c1.hours + 1;
        //c2.hours = c2.hours + 1;
        c1.springForward();
        c2.springForward();

        System.out.println("c1 = " + c1.toString());
        System.out.println("c2 = " + c2);

        //call tick on both c1 and c2
        //print them out again
        

        while (true) {
            Thread.sleep(1000);
        
            //calling method on object
            c1.tick();
            c2.tick();
            
            System.out.println("c1 = " + c1);
            System.out.println("c2 = " + c2);

            Clock.setSeparator(':');
        }
    }

    public static Clock getEarlier(Clock c1, Clock c2) {
        if (c1.getHours() < c2.getHours()) {
            return c1;
        } else if (c2.getHours() < c1.getHours()) {
            return c2;
        } else { //same hour
            if (c1.getMins() < c2.getMins()) {
                return c1;
            } else if (c2. getMins() < c1.getMins()) {
                return c2;
            } else { //same minutes
                if (c1.getSecs() < c2.getSecs()) {
                    return c1;
                } else {
                    return c2;
                }
            }
        }
        */
    }
}
