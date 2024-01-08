package Exceptions;

//import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.util.Scanner;
//import java.io.Reader;

public class AskForCorrectFileName {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /*
        boolean success = false;

        Reader fr = null;

        while(!success) {
            System.out.print("Please enter a file name to read: ");
            String fileName = sc.nextLine(); //read the file name

            try {
                fr = new FileReader(fileName);       
                success = true;

            } catch (FileNotFoundException ex) {
                System.out.println("File not found, try again.");
            }
        }
        */
        sc.close();
    }
}
