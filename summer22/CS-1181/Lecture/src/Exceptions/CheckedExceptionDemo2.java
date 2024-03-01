package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CheckedExceptionDemo2 {
    
    public static void main(String[] args) {

        Reader fr = null;

        try {

            //System.out.println(1/0);
            
            fr = new FileReader("text.txt");        
            //int data = fr.read();
            fr.read();

        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException caught");
            
        } catch (IOException ex) {
            System.out.println("IOException caught");  

        } finally {
            if (fr != null) {
                try {
                    fr.close();    
                } catch (IOException ex) {
                }              
            }
            System.out.println("finish in finally clause");
          
        }

        
    }
}
