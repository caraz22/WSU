import java.util.Scanner;

public class Dumb {
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] dumb = new int[10]; // no need to make this 2 lines

        // must prompt the user before starting the loop
        System.out.print("Pick a number between 1 and 100: ");
        int userNum = in.nextInt();     // no need to parse, you aren't taking from the array, you're just going to be adding to it

        for (int i = 0; i < dumb.length; i++) {
            while (userNum < 1 || userNum > 100) {  // nested loop
                System.out.print("Try again: ");  // invalid number? prompt for new one
                userNum = in.nextInt();             // will repeat until valid number is entered
            }                                       

            if (userNum > 0 && userNum < 101) {
                dumb[i] = userNum;                  // valid number? set dumb at index i to the number

                if (i == 9) {           
                    break;              // breaks out of the loop at the end so that you aren't prompted again once the array is full
                }

                System.out.print("Pick another number: ");      // only reached if i < 9
                userNum = in.nextInt();                           
            }
        }

        for (int i = 0; i < dumb.length; i++) { // printing out the array for debugging
            System.out.print(dumb[i] + " ");
        }

        in.close();
    }
}