package FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileIOCopyLines {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{

        try(BufferedReader inputReader = new BufferedReader(new FileReader("text1.txt"));
                PrintWriter outputWriter = new PrintWriter(new FileWriter("text1out.txt"))) {

            String l;
            while((l = inputReader.readLine()) != null) {
                System.out.println(l);
                String[] tk = l.split(",\\s*");
                System.out.println(Arrays.toString(tk));
                outputWriter.println(l);
            }
        }
    }
}
