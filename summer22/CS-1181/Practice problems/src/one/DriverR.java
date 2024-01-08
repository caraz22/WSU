package one;

import java.util.ArrayList;
import java.util.Collections;

public class DriverR {
    
    public static void main(String[] args) {

        Rating r1 = new Rating();
        System.out.println("r1: " + r1);
        r1.addRating(4.2);
        System.out.println("r1: " + r1);
        r1.addRating(3.9);
        System.out.println("r1: " + r1);

        Rating r2 = new Rating(45, 9);
        System.out.println("r2: " + r2);

        Rating r3 = new Rating(30, 8);
        System.out.println("r3: " + r3);

        ArrayList<Rating> ratings = new ArrayList<>();
        ratings.add(r1);
        ratings.add(r2);
        ratings.add(r3);
        Collections.sort(ratings);
       
        for (Rating r: ratings) {
        System.out.println(r);
        }
    }
}
