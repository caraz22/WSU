package Vehicle;

public class Truck extends Vehicle {

    private int cargoCap;
    private int towCap;
     
    public Truck() {
        super(); //super always has to be first line

        cargoCap = 1000;
        System.out.println("2: truck constructor with no args");
    }

    public Truck(int passengers, int fuelCap, int mpg, int cargoCap) {
        super(passengers, fuelCap, mpg);
        System.out.println("2. truck constructor with args");
    }

    public Truck(int passengers, int fuelCap, int mpg, int cargoCap, int towCap) {
        this(passengers, fuelCap, mpg, cargoCap);
        this.cargoCap = cargoCap;
        this.towCap = towCap;
        System.out.println("2. truck constructor with args");
    }

    public int getCargoCap() {
        return cargoCap;
    }

    @Override
    public String toString() {
        return "Truck{" + "cargoCap=" + cargoCap + "}" + " " + super.toString();
    }

    @Override
    public int range() {
        return super.range() - 2;
    }

    public int towingLoad() {
        return towCap;
    }
}
