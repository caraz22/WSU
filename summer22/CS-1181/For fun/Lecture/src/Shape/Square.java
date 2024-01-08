package Shape;

public class Square extends GeometricShape {
    
    private double s;

    @Override
    public void draw() {
        System.out.println("draw a square");
    }

    @Override
    public double area() {
        return s*s;
    }
}
