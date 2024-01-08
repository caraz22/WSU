package FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileIOScanning {
    
    public static void main(String[] args) throws FileNotFoundException {

        try(Scanner s = new Scanner(new BufferedReader(new FileReader("text1.txt")))) {

            while(s.hasNext()) {
                System.out.println(s.next());
            }
        }
    }
}
