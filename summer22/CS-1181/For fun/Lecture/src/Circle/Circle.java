package Circle;
public class Circle implements Comparable<Circle> {

    private double radius; //private data field; instance variable
    private static int numberOfCircles = 0; //class/static data field/variable

    //no-arg consturctor
    public Circle() {
        this(1.0);
    }

    //constructor with parameter
    public Circle(double radius) {
        this.radius = radius;
        numberOfCircles++;
    }

    //static method
    public static int getNumberOfCircles() {
        return numberOfCircles;
    }

    //instance method
    //setter/mutator
    public void setRadius(double radius) {
        this.radius = radius;
    }

    //getter/accesor
    public double getRadius() {
        return radius;
    }

    public boolean greaterThan(Circle that) {
        return this.radius > that.radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }

    //notation
    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + "}";
    }

    @Override
    public int compareTo(Circle t) {
        if (this.radius < t.radius) {
            return -1;
        } else if (this.radius > t.radius) {
            return 1;
        } else {
            return 0;
        }    
    }
}
