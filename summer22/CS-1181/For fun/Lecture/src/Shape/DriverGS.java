package Shape;

public class DriverGS {
    
    public static void main(String[] args) {
        
        //GeometricShape gs = new GeometricShape();

        Ellipse ellipse = new Ellipse();
        ellipse.draw();

        Square square = new Square();
        square.draw();

        Triangle triangle = new Triangle();
        triangle.draw();

        GeometricShape g;

        g = ellipse;
        g.draw();

        g = triangle;
        g.draw();

        g = square;
        g.draw();

        //g.rotate();

        Object o = triangle;
        ((Triangle) o).draw();
        ((Triangle) o).rotate();
    }
}
