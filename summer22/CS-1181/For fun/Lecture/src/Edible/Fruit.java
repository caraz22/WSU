package Edible;

public class Fruit implements Edible, Comparable<Fruit> {
    
    private String name;
    private double price;

    public Fruit() {

    }

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String howToEat() {
        return "For fruits, wash and serve";
    }

    @Override
    public int compareTo(Fruit t) {
        return Double.compare(this.price, t.price);
    }
}
