import java.io.*;

public class FilePractice {

    public static void main(String[] args) throws Exception {

        PrintWriter pw = new PrintWriter("test_file.txt");
        pw.println("Hello, World!");
        //pw.flush();
        pw.close();
    }
    
}
