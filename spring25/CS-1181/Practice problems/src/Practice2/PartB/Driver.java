package Practice2.PartB;

import java.util.ArrayList;

public class Driver {
    
    public static void main(String[] args) {

        Golfer golfer1 = new Golfer("Jay", "Smith", -13, 17);
        Golfer golfer2 = new Golfer("DeShaun", "Smith", -11, 16);
        Golfer golfer3 = new Golfer("DeShaun", "Taylor", -11, 2);

        ArrayList<Golfer> golfers = new ArrayList<>();
        golfers.add(golfer1);
        golfers.add(golfer2);
        golfers.add(golfer3);

        System.out.println(golfers);
    }
}
