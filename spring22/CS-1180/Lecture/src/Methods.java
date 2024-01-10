import java.util.Scanner;

public class Methods {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        in.close();
    }        
/*
        int x = 5;
        int y = 10;
        add(x, y); //this makes no sense at all -- we are not doing anything with ther returned value!

        int a = 4;
        int b = 6;
        foo(a, b);
        System.out.println("a = " + a + " b = " + b);
*/

/*
    public static int add(int n1, int n2) {
        int sum = n1 + n2;
        return sum;
    }
            //all parameters in Java are pass-by-value
    public static void foo(int a, int b) {
        a = -a;
        b += 2;
        System.out.println("a = " + a + " b = " + b);
    }

        
        int posVal = getIntBetween(1, 10);
        int negVal = getIntBetween(-10, -1);

        System.out.println(posVal + " " + negVal);
        
        //read in two integers
        //write and call an add method to add them together
        //print out the sum

        System.out.println("What is the sum of the two integers? ");
        int a = in.nextInt();
        int b = in.nextInt();

        int total = add(a, b);

        System.out.println("total = " + total);
*/
        /*
        System.out.println("What are the 3 strings? ");
        String s1 = in.next();
        String s2 = in.next();
        String s3 = in.next();

        // s = hello; mid = 'l'
        // s = test; mid = 'e'

        char mid1 = getMiddleChar(s1);
        char mid2 = getMiddleChar(s2);
        char mid3 = getMiddleChar(s3);

        System.out.println("The middle character of string 1 is " + mid1);
        System.out.println("The middle character of the string 2 " + mid2);
        System.out.println("The middle character of the string 3 " + mid3);
        */



        //prompt the user for a value between the bounds
        //read in what they say
        //if they don't follow directions, yell at them and prompt again
        //when you give something valid, return it
        //call your method from main to test it
    /*
    public static int getIntBetween(int lowerBound, int upperBound) {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number between " + lowerBound + " and " + upperBound + ": ");
            int number = in.nextInt();

            if (number < lowerBound || number > upperBound) {
            System.out.println("That is not within the requested range!");
            }  else {
                return number;
            }
        in.close();
        }
    }
    */
/*
    public static int add(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }
*/
    /*
    public static char getMiddleChar(String s) {
        char mid = s.charAt((s.length()-1)/2);
        return mid;   
    }
    */
    
    


}    

