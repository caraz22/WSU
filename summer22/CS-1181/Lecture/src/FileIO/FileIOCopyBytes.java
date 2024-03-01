package FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOCopyBytes {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try(FileInputStream in = new FileInputStream("text1.txt");
                FileOutputStream out = new FileOutputStream("textout.txt")) {

            int c; //variable that holds a byte value in its last 8 bits

            while((c = in.read()) != -1) {
                out.write(c);
            }
        }
    }
}
