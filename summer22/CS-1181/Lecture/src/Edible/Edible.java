package Edible;

public interface Edible {
    
    static final int numRecipes = 2;
    String howToEat();

    default String specialInstructions() {
        return "Sprinkle salt and pepper.";
    }

    static String specialRecipe() {
        return "A secret recipe";
    }
}
