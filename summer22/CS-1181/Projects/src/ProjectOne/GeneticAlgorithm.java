package ProjectOne;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;

public class GeneticAlgorithm {

    public static final int popSize = 20;
    public static final int numEpochs = 1000;
    public static final int numThreads = 5;
    
    public static ArrayList<Item> readData(String fileName) throws FileNotFoundException { 
        Scanner items = new Scanner(new File("Projects/src/txt/more_items.txt")); //reading in the data file
        ArrayList<Item> itemObjects = new ArrayList<>(); //arraylist of Item objects

        while (items.hasNextLine()) {
            String itemDetails = items.nextLine(); //creating a string for each line of the data file
            String[] eachDetail = itemDetails.split(", "); //splitting the string into an array of strings
            String itemLabel = eachDetail[0]; 
            double itemWeight = Double.parseDouble(eachDetail[1]);
            int itemValue = Integer.parseInt(eachDetail[2]);

            Item item = new Item(itemLabel, itemWeight, itemValue); //filling in the Item format
            itemObjects.add(item); //adding each item to arrayList of Item objects
        }

        items.close();
        return itemObjects;
    }

    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize) {
        ArrayList<Chromosome> population = new ArrayList<>(); //creating array list of population size chromosome objects
        while (population.size() < populationSize) { //making sure the array size doesn't exceed the population size
            Chromosome objects = new Chromosome(items); //creating chromosome objects
            population.add(objects);
        }

        return population;
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException { //running the genetic algorithm

        ArrayList<Item> initialPopulation = readData("Projects/src/txt/more_items.txt"); //reading in txt file
        ArrayList<Chromosome> currentPopulation = initializePopulation(initialPopulation, popSize); //creating current population using the initial population's items

        // ArrayList<Multithreading> threads = new ArrayList<>();
        // for (int i = 0; i < numThreads; i++) {
        //     Multithreading thread = new Multithreading(popSize, numEpochs, numThreads, currentPopulation);
        //     threads.add(thread);
        //     thread.start();
        //     thread.join();
        // }

        // Collections.sort(threads);

        // for (Multithreading thread : threads) { //displaying the fittest individual to the console
        //     System.out.println(thread);
        //     System.out.println();
        // }
    }
}
