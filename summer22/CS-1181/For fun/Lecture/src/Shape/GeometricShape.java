package Shape;

//import java.awt.Color;

public abstract class GeometricShape {
    
    // private int x;
    // private int y;
    // private Color c;

    public abstract void draw();
    public abstract double area();

    public void move(int x, int y) {
        // this.x = x;
        // this.y = y;
    }
}
