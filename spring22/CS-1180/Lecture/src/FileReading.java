import java.io.*;
import java.util.Scanner;

public class FileReading {

    public static void main(String[] args) throws Exception {

        //prompt the user for a sentence. Write that sentence to the file test1.txt
        //
        //open test1.txt and create a new file called test1.copy
        //copy everything from test1.txt to test1.copy

        Scanner in = new Scanner(System.in);
        
        System.out.print("Write a sentence: ");
        String sentence = in.nextLine();
        
        PrintWriter pw = new PrintWriter("test1.txt");
        pw.println(sentence);
        pw.close();

        Scanner originalFile = new Scanner(new File("test1.txt"));

        // File copy = new File("test1.copy.txt");
        // PrintWriter pw2 = new PrintWriter(copy);
        // String copyOf1 = originalFile.nextLine();
        // pw2.print("The exact sentence from test1.txt is: '" + copyOf1 + "'");
        // pw2.close();

        PrintWriter pw2 = new PrintWriter(new File("test1.copy.txt"));

        while(originalFile.hasNextLine()) {
            String copyOf1 = originalFile.nextLine();
            pw2.println(copyOf1);
      }
        pw2.close();
        

        //File dir = new File(".");
        //System.out.println(dir.getAbsolutePath());
        //^^tells you where to put your text file so that you can read it in
        /*
        Scanner fileIn = new Scanner(new File("example.txt"));
        
        int wordCount = 0;
        while (fileIn.hasNext()) {
            String line = fileIn.next();
            //System.out.println(line);
            wordCount++;
        }
        System.out.println("There are " + wordCount + " words.");
        */

        in.close();
    }

}
