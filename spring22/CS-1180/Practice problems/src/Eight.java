//Cara Zozokos
import java.util.Arrays;
import java.util.Scanner;

public class Eight {

    public static int[] maxArray(int[] a1, int[] a2) {
        int[] finalArray = new int[5];
        for (int i=0; i<5; i++) {
            if (a1[i] > a2[i]) {
                finalArray[i] = a1[i];
            } else {
                finalArray[i] = a2[i];
            }
        }
        return finalArray;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter ten values, separated by spaces: ");

        int[] values = new int[10];

        for (int i=0; i<10; i++) {
            values[i] = in.nextInt();
        }

        int[] array1 = new int[5];
        for (int i=0; i<5; i++) {
            array1[i] = values[i];
        }

        int[] array2 = new int[5];
        for (int i=0; i<5; i++) {
            array2[i] = values[i+5];
        }

        /*
        String arr1 = " ";
        for (int i=0; i<5; i++) {
            arr1 = array1[i] + " ";
        }

        String arr2 = " ";
        for (int i=0; i<5; i++) {
            arr2 = array2[i] + " ";
        }

        System.out.println("Array 1: " + arr1);
        System.out.println("Array 2: " + arr2);
        */
        System.out.println("Array 1: " + Arrays.toString(array1) + " ");
        System.out.println("Array 2: " + Arrays.toString(array2) + " ");

        int[] finalArray = maxArray(array1, array2);
        System.out.println("Final Array: " + Arrays.toString(finalArray) + " ");
        
        in.close();
    }
}
