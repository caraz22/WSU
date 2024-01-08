package ProjectOne;
import java.util.Random;
import java.util.ArrayList;

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> { 
    
    private static Random rng = new Random(); //for random number generating
    public static long dummy = 0;

    public Chromosome() { 
        //empty constructor
    }

    public Chromosome(ArrayList<Item> items) { 
        ArrayList<Item> itemsCopy = new ArrayList<>(); //creating a copy array
        for (int i = 0; i < items.size(); i++) { //copying everything from items into itemsCopy
            itemsCopy.add(new Item(items.get(i)));
        }

       for (Item item : itemsCopy) { //for each item in itemsCopy
           int itemNum = rng.nextInt(2);
           if (itemNum == 0) { //if statement to randomly determine if the item's included field is true or false
               item.setIncluded(true);
           } else {
               item.setIncluded(false);
           }
           this.add(item); 
       }
    }

    public Chromosome crossover(Chromosome other) {
        ArrayList<Item> itemsCopy = new ArrayList<>(); //creating a copy array
        for (int i = 0; i < this.size(); i++) { //copying new items from this chromosome to itemsCopy
            itemsCopy.add(new Item(this.get(i)));
        }

        Chromosome child = new Chromosome(itemsCopy); //creating child chromosome
        for (int i = 0; i < this.size(); i++) { //for loop for crossover
            int itemNum = rng.nextInt(11);
            if (itemNum >=1 && itemNum <= 5) {
                child.get(i).setIncluded(this.get(i).isIncluded());
            } else {
                child.get(i).setIncluded(other.get(i).isIncluded());
            }
        }

        return child; //returning child chromosome
    }

    public void mutate() {
        for (int i = 0; i < this.size(); i++) { //for loop for mutation
            int itemNum = rng.nextInt(11);
            if (itemNum <= 2) {
                if (this.get(i).isIncluded() == false) { //if itemNum is 1 and the item's included field is false, change it to true
                    this.get(i).setIncluded(true);                    
                } else { //otherwise vice versa
                    this.get(i).setIncluded(false);
                }
            } 
        }
    }

    public int getFitness() {
        dummy = 0;
        for (int i = 0; i < this.size() * 1000; i++) {
            dummy += i;
        }
        
        double weight = 0;
        int value = 0;
        for (int i = 0; i < this.size(); i++) { //for loop to determine fitness
            if (this.get(i).isIncluded() == true) { //if included field is true, add the item's weight and value onto the next
                weight += this.get(i).getWeight();
                value += this.get(i).getValue();
            }
        }

        if (weight > 10) { //if the sum of the included items' weights is greater than 10, the fitness is 0
            return 0;
        } else { //otherwise, the fitness is equal to the sum of all the included items' values
            return value;
        }
    }

    @Override
    public int compareTo(Chromosome other) {
        if (this.getFitness() > other.getFitness()) { //if this chromosome's fitness is greater than the other's, return -1
            return -1;
        } else if (this.getFitness() < other.getFitness()) { //if this chromosome's fitness is less than the other's, return 0
            return 1;
        } else { //if the fitnesses are the same, return 0
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(); //building a string
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).isIncluded()) {
                string.append(this.get(i).toString()); //using the toString() method from Item.java for this toString() method
                string.append(" ");                
            }
        }
        
        string.append("Fitness: "  + this.getFitness()); //adding the fitness to the string
        return string.toString();
    }
}
