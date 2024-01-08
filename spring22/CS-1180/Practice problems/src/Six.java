//Cara Zozokos

import java.util.Scanner;

public class Six {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        
        // int height = getHeight("Enter height: ");
        // char s = getChar("Enter character: ");
        // char triangle = getTriangle(s, height);
        
    }

    public static int getHeight(String prompt) {
        System.out.print(prompt);
        return in.nextInt();
    }

    public static char getChar(String prompt) {
        System.out.print(prompt);
        return in.next().charAt(0);
    }

    public static char getTriangle(char s, int height) {
        for (int i=0; i<=height; i++) {
            for (int j=0; j<height; j++) {
                if (j < i) {
                    System.out.print(" ");
                } else {
                    System.out.print(s);
                }
            }
            System.out.println();
        }
        return s;
    }
    
}
