import java.util.Arrays;
import java.util.Scanner;

public class loop
{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);


        int userInput;
        int[] dumb;
        dumb = new int[10];

        int i=0;
        while (i !=10-1 ) {
            System.out.println("Pick a number between 1-100");
            userInput = Integer.parseInt(in.nextLine());
            if (userInput >100){
                System.out.println("please try again, number too large");
            }
            if (userInput <100){
                System.out.println("That's a valid number!");
                dumb[i] = userInput;
                i++;
            }


        }
        System.out.println(Arrays.toString(dumb));

        in.close();
    }
}