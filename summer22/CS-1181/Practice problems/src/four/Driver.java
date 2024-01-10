package four;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

    public static int fibonacci(int n) throws InvalidArgumentException {
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;

        if (n < 0) {
            System.out.println("Error: " + n + " is not a positive number");
            throw new InvalidArgumentException("negative number exception");
        } else {
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    f3 = 1;
                } else {
                    f3 = f1 + f2;
                    f1 = f2;
                    f2 = f3;
                }
            }

            return f3;
        }
    }
    
    public static void main(String[] args) throws InputMismatchException {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the desired Fibonacci number n: ");

        boolean inputIncorrect = true;

        while (inputIncorrect) {
            if (in.hasNextInt()) {
                try {
                    int n = in.nextInt();
                    System.out.println(Driver.fibonacci(n));
                    inputIncorrect = false;
                } catch (InvalidArgumentException ex) {
                    System.out.print("Please enter a positive number: ");
                    inputIncorrect = true;
                }
            } else {
                try {
                    int n = in.nextInt();
                    System.out.println(n);
                    inputIncorrect = false;
                } catch (InputMismatchException ex2) {
                    System.out.println("Error: you must enter a number");
                    System.out.print("Please enter an integer: ");
                    in.next();
                    inputIncorrect = true;
                }    
            }            
        }



        in.close();
    }
}

class InvalidArgumentException extends Exception {
    public InvalidArgumentException(String message) {
        super(message);
    }
}
