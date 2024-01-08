package Shape;

public class Ellipse extends GeometricShape {
    
    private double a; //semi-major axis
    private double b; //semi-minor axis
    @Override
    public void draw() {
        System.out.println("draw an ellipse");
    }

    @Override
    public double area() {
        return Math.PI * a * b;
    }
}
