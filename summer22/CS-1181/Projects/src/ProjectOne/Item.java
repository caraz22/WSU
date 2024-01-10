package ProjectOne;
public class Item {
    
    //fields of the class
    private final String name;
    private final double weight;
    private final int value;
    private boolean included;

    public Item(String name, double weight, int value) { //constructor
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public Item(Item other) { //setting this item's fields equal to the other's
        this.name = other.name;
        this.weight = other.weight;
        this.value = other.value;
    }

    //getters
    public double getWeight() {
        return weight;
    }
    public int getValue() {
        return value;
    }
    public boolean isIncluded() {
        return included;
    }

    //setter
    public void setIncluded(boolean included) {
        this.included = included;
    }

    //toString method
    public String toString() {
        return name + (" (" + weight + "lbs, $" + value + "),");
    }
}
