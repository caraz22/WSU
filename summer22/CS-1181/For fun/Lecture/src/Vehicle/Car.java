package Vehicle;

public class Car extends Vehicle {
    
    public Car() {
        super();
        System.out.println("2: Car no-arg constructor");
    }

    @Override
    public String toString() {
        return "Car{" + "}";
    }

    @Override
    public int range() {
        return super.range() + 2;
    }
}
