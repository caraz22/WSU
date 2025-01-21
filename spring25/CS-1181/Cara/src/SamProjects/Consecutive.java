package SamProjects;

import java.util.ArrayList;


public class Consecutive {
    
    public static void main(String[] args) {

        int[] randomNums = new int[1000];

        for (int i = 0; i < randomNums.length; i++) {
            int randomNum = (int) (Math.random() * 201) - 100;
            randomNums[i] = randomNum;
        }

        ArrayList<ArrayList<Integer>> consecutiveNumsList = new ArrayList<>();

        for (int i = 0; i < randomNums.length; i++) {
            int index = 0;
            if (i < randomNums.length - 1 && randomNums[i + 1] == randomNums[i] + 1) {
                consecutiveNumsList.add(consecutiveNums(i, randomNums));
                if (consecutiveNumsList.get(index).isEmpty() == true) {
                    consecutiveNumsList.remove(consecutiveNumsList.get(index));
                } else if (consecutiveNumsList.get(index).size() > 0) {
                    index++;
                    int skip = skipNums(consecutiveNumsList.get(index - 1));
                    i += (skip - 1);
                }                
            }
        }

        int largestSize = 0;
        for (int i = 0; i < consecutiveNumsList.size(); i++) {
            if (consecutiveNumsList.get(i).size() > largestSize) {
                largestSize = consecutiveNumsList.get(i).size();
            }
        }

        if (largestSize == 0) {
            System.out.println("There were no strings of consecutive numbers.");
        } else {
            System.out.println("The largest string of consecutive numbers is " + largestSize + ".");
            System.out.println("Here is a list of strings with that size:");            
        }


        for (int i = 0; i < consecutiveNumsList.size(); i++) {
            if (consecutiveNumsList.get(i).size() == largestSize) {
                System.out.println(consecutiveNumsList.get(i));
            }
        }
    }

    public static ArrayList<Integer> consecutiveNums (int value, int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = value; i < array.length; i++) {
            int arrayValue = array[i];
            int increment = Math.incrementExact(arrayValue);
            if (i < array.length - 1 && array[i + 1] == increment) {
                arrayList.add(array[i]);
            } else if (i > 0 && array[i] == Math.incrementExact(array[i - 1])) {
                arrayList.add(array[i]);
                break;
            }
        }

        return arrayList;
    }

    public static int skipNums(ArrayList<Integer> consecutiveNums) {
        int skip = consecutiveNums.size();
        return skip;
    }
}
