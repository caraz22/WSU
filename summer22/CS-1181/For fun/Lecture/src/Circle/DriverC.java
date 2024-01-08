package Circle;
import java.util.ArrayList;
import java.util.Collections;

public class DriverC {
    
    public static void main(String args[]) {

        Circle c1 = new Circle();
        System.out.println("c1 radius: " + c1.getRadius());
        System.out.println("c1 area: " + c1.getArea());
        System.out.println("c1 perimeter: " + c1.getPerimeter());
        System.out.println("number of circles: " + Circle.getNumberOfCircles());
        //System.out.println("number of circles: " c1.getNumberOfCircles());
        //^not good style: should invoke static method using class name

        //System.out.println(Circle.radius); //error, cannot access instance variable
        Circle c2 = new Circle(10);
        System.out.println("c2 radius: " + c2.getRadius());
        c2.setRadius(100);
        System.out.println("c2 radius: " + c2.getRadius());
        System.out.println("number of circles: " + Circle.getNumberOfCircles());

        System.out.println(c1); //toString() is auto involved

        c1.setRadius(200);
        c2.setRadius(200);

        if (c1 == c2) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }

        //ArrayList: dynamic array
        ArrayList<Circle> lc = new ArrayList<>();
        lc.add(c2);
        lc.add(c1);
        System.out.println(lc);

        //Sort the list of Circles
        //lc.sort(null);
        Collections.sort(lc);
        System.out.println(lc);

        //Circle c3 = null;
    }
}
