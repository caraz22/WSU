//import java.util.Arrays;
import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.Collections;

public class ArrayStuff {

    /*
    public static void foo(int x) {
        x = x + 1;
    }

    public static void shiftRight(int[] arr) {
        int last = arr[arr.length-1];
        for (int i=arr.length-1; i>=1; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = last;
    }
    */

    //write a method that takes two int arrays
    //and return a new array where each value is the sum of the
    //two imput array values at that location
    //[1, 2, 3] [2, 2, 2] => [3, 4, 5]
    //call your metho from main to test if that works

    public static int[] sumOfArrays(int[] a, int[] b) {
        int[] sum = new int[a.length];

        for(int i=0; i<a.length; i++) {
            sum[i] = a[i] + b[i];
        }

        return sum;
    }

    public static int[] copy(int[] origArr) {
        int[] copyArr = new int[origArr.length];
        for (int i=0; i<origArr.length; i++) {
            copyArr[i] = origArr[i];
        }
        return copyArr;
    }

    //this method should return an array that has all the elements of the old array
    //except with any zeros removed
    //[3, 9, 0, 0, 9, 0] -> [3, 9, 9]
    public static int[] removeZeros(int[] arr) {
        int numZeros = 0;
        for (int i =0; i<arr.length; i++) {
            if (arr[i] == 0) {
                numZeros++;
            }
        }

        int[] newArr = new int[arr.length-numZeros];
        int newPos = 0;

        for (int i=0; i<arr.length; i++) {
            if(arr[i] != 0) {
                newArr[newPos++] = arr[i];
            }
        }
        return newArr;
    }

    public static void shuffle(int[] arr) {
        
        //loop over all the elements in arr
        //for each one, generate a random index between 0 and arr.length-1
        //swap the element you're on with the element at that index
        for (int i=0; i<arr.length; i++) {
            int idx = (int) (Math.random() * arr.length);
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        } 
    }

    public static boolean isValidPassword(String s) {
        //8 characters, at least one upper and lower case letter, at least 1 digit and special character
        char[] arr = s.toCharArray();

        if (arr.length < 0) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasSpecial = false;
        boolean hasDigit = false;

        for (int i=0; i<arr.length; i++){
            if (Character.isUpperCase(arr[i])) {
                hasUpper = true;
            }
            if (Character.isLowerCase(arr[i])) {
                hasLower = true;
            }
            if (Character.isDigit(arr[i])) {
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(arr[i])) {
                hasSpecial = true;
            }
        }
        //to do -- replace this with code that checks if s meets the conditions for a valid password
        return hasUpper && hasLower && hasDigit && hasSpecial; 
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        //Prompt the user for a password until they give you a valid one
        while (true) {
            System.out.print("Choose a password: ");
            String password = in.nextLine();
            if (!isValidPassword(password)) {
                System.out.println(password + "is not a valid password.");
            } else {
                break;
            }
        }

        /*
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Eve");
        names.add("Charlie");
        System.out.println(names);
        names.add(1, "Berry");
        System.out.println(names);
        */

        /*
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0; i<10; i++) {
            arr.add(i);
        }
        System.out.println(arr);
        Collections.shuffle(arr);
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
        Collections.reverse(arr);
        System.out.println(arr);
        //arr.add(4, 99); //adds in a new value and shifts the others over
        arr.set(4, 99); //overwrites that index with the new value, no shifting
        System.out.println(arr);
        */

        /*
        //in array lists:
        //int -> Integer
        //double -> Double
        //char -> Character
        ArrayList<Integer> arrList = new ArrayList<>();
        ArrayList<Integer> toRemove = new ArrayList<>();
        arrList.add(3);
        arrList.add(9);
        arrList.add(0);
        arrList.add(0);
        arrList.add(9);
        arrList.add(0);
        System.out.println(arrList);
        
        //  (int i=0; i<arrList.size(); i++) {
        //     Integer item = arrList.get(i);
        
        for (Integer item: arrList) { //called a "for each" loop, can be use with AL's or plain arrays        
            if (item == 0) {
                toRemove.add(item);
            }
        }
        arrList.removeAll(toRemove);
        System.out.println(arrList);
        System.out.println(arrList.get(0));
        */

        /*
        int[] arr = new int[10];
        for (int i=0; i<arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
        */

        /*
        int[] a1 = {3, 9, 0, 0, 9, 0};
        int[] a2 = removeZeros(a1);
        System.out.println(Arrays.toString(a2));
        */
        /*
        int[] a1 = new int[4];
        a1[0] = 2;
        a1[1] = 4;
        a1[2] = 6;

        System.out.println(Arrays.toString(a1));

        // int[] a2 = a1;
        int[] a2 = copy(a1);
        System.out.println(Arrays.toString(a2) + "\n");
        a1[3] = 14;
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        */

        /*
        int [] arr1 = {1, 2, 3};
        int[] arr2 = {2, 2, 2};
        int[] answer = sumOfArrays(arr1, arr2);
        System.out.println(Arrays.toString(arr1) + " + " + Arrays.toString(arr2) + " = " + Arrays.toString(answer));
        */

        // int[] test = {8, 2, 5, 6, 7};
        // System.out.println("Test = " + Arrays.toString(test));
        // shiftRight(test);
        // System.out.println("Test = " + Arrays.toString(test));

        // int i = 3;
        // System.out.println("i = " + i);
        // foo(i);
        // System.out.println("i = " + i);

        // int[] numbers = new int[10];
        // for(int i=0; i<10; i++) {
        //     numbers[i] = (int) (Math.random() * 100) + 1;
        // }
        // int[] test = {8, 2, 5, 6, 7}; //hard coding in the array
        // System.out.println(Arrays.toString(test));
        
        // int last = test[test.length-1];
        // for (int i=test.length-1; i>=1; i--) {
        //     test[i] = test[i-1];
        //     //System.out.println(Arrays.toString(test));
        // }
        // /*
        // System.out.println(Arrays.toString(test));
        // test[3] = test[2];
        // System.out.println(Arrays.toString(test));
        // test[2] = test[1];
        // System.out.println(Arrays.toString(test));
        // test[1] = test[0];
        // System.out.println(Arrays.toString(test));
        // */
        // test[0] = last;
        // System.out.println(Arrays.toString(test));

        //try to write code that shifts all items in the list one place to the right
        //then the last number should wrap around and become the first one
        //for example: [8, 2, 5, 6, 7] -> [7, 8, 2, 5, 6]


        //write code to find the average of all the numbers in the array
        /*
        double sum = 0;
        for (int i=0; i<numbers.length; i++) {
            System.out.print(numbers[i] + " ");
            sum += numbers[i];
        }
        System.out.println(" ");
        double average = sum / numbers.length;
        System.out.println("The average of the numbers is " + average);
        */

        //try to write a loop that prints out all the numbers
        //THEN
        //try to write a loop that figures out which number is the largest
        /*
        int biggest = numbers[0];
        for (int i=0; i<numbers.length; i++) {
            System.out.print(numbers[i] + " ");
            if (numbers[i] > biggest) {
                biggest = numbers[i];
            }
        }
        System.out.println();
        System.out.println("The biggest number is " + biggest);
        */
        /*
        String[] list = new String[4];
        list[0] = "Hello";
        list[1] = "Dr.";
        list[2] = "Michelle";
        list[3] = "Cheatham";

        System.out.println(list[1]);
        System.out.println("The length of the list is " + list.length);

        for(int i=0; i<list.length; i++) {
        System.out.print(list[i] + " ");
        //System.out.print(" ");
        }
        System.out.println();

        //write a single print statement that prints the last String in an array called list,
        //no matter how big the list is
        System.out.println("The last string is " + list[list.length - 1]);
        */

        /*
        System.out.print(list[0]);
        System.out.print(" ");
        System.out.print(list[1]);
        System.out.print(" ");
        System.out.print(list[2]);
        System.out.print(" ");
        */

        in.close();
    }
    
}
