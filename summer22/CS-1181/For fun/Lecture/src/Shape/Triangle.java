package Shape;

public class Triangle extends GeometricShape {
    
    private double a;
    private double b;
    private double c;

    public void draw() {
        System.out.println("draw a triangle");
    }

    public double area() { //Heron's formula
        double s = 0.5 * (a + b + c);
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public void rotate() {
        System.out.println("rotate a triangle");
    }
}
