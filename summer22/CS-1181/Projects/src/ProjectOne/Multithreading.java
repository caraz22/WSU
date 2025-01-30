// package ProjectOne;

// import java.util.ArrayList;
// import java.util.Collections;

// public class Multithreading extends Thread implements Comparable<Multithreading> {

//     public final int popSize;
//     public final int numEpochs;
//     public final int numThreads;
//     public ArrayList<Chromosome> currentPopulation = new ArrayList<>();

//     public Multithreading(int popSize, int numEpochs, int numThreads, ArrayList<Chromosome> currentPopulation) {
//         this.popSize = popSize;
//         this.numEpochs = numEpochs;
//         this.numThreads = numThreads;
//         this.currentPopulation = currentPopulation;
//     }

//     public int getNumEpochs() {
//         return numEpochs;
//     }

//     public int getNumThreads() {
//         return numThreads;
//     }

//     public ArrayList<Chromosome> getCurrentPopulation() {
//         return currentPopulation;
//     }

//     @Override
//     public int compareTo(Multithreading other) {
//         if (this.currentPopulation.get(0).getFitness() < other.currentPopulation.get(0).getFitness()) {
//             return 1;
//         } else if (this.currentPopulation.get(0).getFitness() > other.currentPopulation.get(0).getFitness()) {
//             return -1;
//         } else {
//             return 0;
//         }
//     }

//     @Override
//     public void run() {
        
//         ArrayList<Chromosome> nextGeneration = new ArrayList<>(); //creating the next generation

//         nextGeneration.addAll(currentPopulation); //adding the current population to the next generation

//         for (int i = 0; i < numEpochs/numThreads; i++) { //repeat numEpochs/numThreads times
//             Collections.shuffle(nextGeneration); //shuffling so that the pairing is random
//             Collections.shuffle(currentPopulation);
//             for (int j = 0; j < currentPopulation.size(); j++) { //pair individuals to perform crossover
//                 nextGeneration.add(nextGeneration.get(i).crossover(currentPopulation.get(i))); //adding the crossover child to the next generation
//             }

//             currentPopulation.clear();
//             Collections.shuffle(nextGeneration);

//             for (int j = 0; j < (nextGeneration.size() * 0.1); j++) { //mutating 10 percent of the next generation
//                 nextGeneration.get(i).mutate();
//             }

//             Collections.sort(nextGeneration); //sorting the individuals according to their fitness

//             for (int j = nextGeneration.size() - 1; j > 19; j--) { //only keeping the top twenty of the next generation
//                 nextGeneration.remove(i);
//             }

//             for (int j = 0; j < 20; j++) {
//                 currentPopulation.add(nextGeneration.get(i));
//             }
//         }

//         Collections.sort(currentPopulation);
//     }
// }
