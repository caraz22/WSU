//Cara Zozokos
import java.io.*;
import java.util.Scanner;

public class Nine {
    
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(new File("test.txt"));

        int rows = input.nextInt();
        int columns = input.nextInt();
        int[][] plusMinus = new int[rows][columns];
        System.out.print(plusMinus);
    }
}
