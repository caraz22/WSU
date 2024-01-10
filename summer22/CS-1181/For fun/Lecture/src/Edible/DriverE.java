package Edible;

public class DriverE {
    
    public static void main(String[] args) {

        Beef ribeye = new Beef();
        System.out.println("Beef " + ribeye.howToEat()); //abstract method
        System.out.println("Beef: " + ribeye.specialInstructions()); //default concrete method
        System.out.println("Number of recipes: " + Edible.numRecipes); //static final variable
        System.out.println("Special recipe: " + Edible.specialRecipe()); //static method

        Vegetable asparagus = new Vegetable();
        System.out.println("Asparagus " + asparagus.howToEat());

        // Edible edible = new Fruit("apple", 1.0);
        // Comparable<Fruit> comp = new Fruit("kiwi", 2.0);
    }
}
