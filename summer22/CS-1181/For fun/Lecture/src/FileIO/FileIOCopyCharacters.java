package FileIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIOCopyCharacters {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {

        try(FileReader inputReader = new FileReader("text1.txt");
                FileWriter outputWriter = new FileWriter("text1out.txt")) {

            int c;
            while((c = inputReader.read()) != -1) {
                outputWriter.write(c);
            }
        }
    }
}
