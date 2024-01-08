package Exceptions;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.PrintWriter;

public class TryWithResources {
    
    public static void main(String[] args) {

        try(Reader in = new FileReader("text.txt");
                PrintWriter wr = new PrintWriter("textout.txt")) {

            int data = in.read(); //read() may cause an IOException

            while (data != -1) {
                System.out.print((char) data);
                data = in.read();
                wr.write(data);
            }

            System.out.println("");

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } //no finally needed
    }
}
