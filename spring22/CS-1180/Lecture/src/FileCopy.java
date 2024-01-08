import java.io.*;
import java.util.Scanner;

public class FileCopy {

    public static void main(String[] args) throws Exception {

        String file1 = args[0];
        String file2 = args[1];

        Scanner fileIn = new Scanner(new File(file1));
        PrintWriter pw = new PrintWriter(new File(file2));

        while (fileIn.hasNextLine()) {
            String line = fileIn.nextLine();
            pw.println(line);
        }
        pw.close();

    }
    
}
