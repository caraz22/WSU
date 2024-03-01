package Vehicle;

public class DriverV {
    
    public static void main(String[] args) {

        Vehicle v = new Vehicle();
        System.out.println(v);

        Truck truck = new Truck(5, 30, 10, 1000);
        System.out.println("truck " + truck);

        Car car = new Car();
        v = car;
        car = (Car) v; //downcasting

        boolean isCar = v instanceof Car;
        System.out.println("isCar " + isCar);

        System.out.println("car range: " + v.range());

        v = new Truck(5, 30, 10, 1000, 12000);
        
        System.out.println("truck range: " + v.range());

        //System.out.println(v.towCap);
    }
}