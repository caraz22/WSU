//Cara Zozokos
import java.util.Scanner;
import java.io.*;

public class Seven {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a file name (include '.txt' at the end): ");
        String file = in.nextLine();

        int period = file.indexOf(".");
        String fileName = file.substring(0, period);

        PrintWriter pw = new PrintWriter(file);
        pw.println("Hello my name is Cara and I am a student.");
        pw.close();

        System.out.print("Enter a small number: ");
        int num = in.nextInt();

        String copy = (fileName + "_copy.txt");
        PrintWriter pw2 = new PrintWriter(new File(copy));
        
        Scanner originalFile = new Scanner(new File(file));

        int wordCount = 1;
        while (originalFile.hasNext()) {
            if (wordCount % num == 0) {
                pw2.print(originalFile.next().toUpperCase() + " ");
            } else {
                pw2.print(originalFile.next() + " ");
            }
            wordCount++;
        }

        pw2.close();

        System.out.println("File " + copy + " has been created");

        in.close();
    }
    
}
