import java.util.Scanner;

public class Dumb {
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] dumb = new int[10];

        System.out.print("Pick a number between 1 and 100: ");
        int userNum = in.nextInt();

        for (int i = 0; i < dumb.length; i++) {
            while (userNum < 1 || userNum > 100) {
                System.out.print("Try again: ");
                userNum = in.nextInt();
            }

            if (userNum > 0 && userNum < 101) {
                dumb[i] = userNum;

                if (i == 9) {
                    break;
                }

                System.out.print("Pick another number: ");
                userNum = in.nextInt();
            }
        }

        for (int i = 0; i < dumb.length; i++) { // printing out the array for debugging
            System.out.print(dumb[i] + " ");
        }

        in.close();
    }
}