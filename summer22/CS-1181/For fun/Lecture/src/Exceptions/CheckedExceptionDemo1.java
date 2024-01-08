package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CheckedExceptionDemo1 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {

        Reader fr = null;

        fr = new FileReader("text.txt");

        int data = fr.read(); //read() may cause an IOException

        while(data != -1) {
            System.out.print((char) data);
            data = fr.read();
        }

        fr.close();

        System.out.println("finish");
    }
}
