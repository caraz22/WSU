package Vehicle;

public class Vehicle {
    
    private int passengers;
    private int fuelCap;
    private int mpg;

    public Vehicle(int passengers, int fuelCap, int mpg) {
        this.passengers = passengers;
        this.fuelCap = fuelCap;
        this.mpg = mpg;
        System.out.println("1: Vehicle constructor with args");
    }

    public Vehicle() {
        passengers = 2;
        fuelCap = 15;
        mpg = 25;
        System.out.println("1: Vehicle constructor with no args");
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getFuelCap() {
        return fuelCap;
    }

    public void setFuelCap(int fuelCap) {
        this.fuelCap = fuelCap;
    }

    public int getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    public int range() {
        return fuelCap * mpg;
    }

    public double fuelNeeded(int miles) {
        return (double) miles / mpg;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "passengers=" + passengers + ", fuelCap=" + fuelCap + ", mpg=" + mpg + "}";
    }
}
