package ProjectTwo;

import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException {

        File file = new File("Projects/src/txt/directions.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }

        System.out.println(sb);

        br.close();
        fr.close();
    }
}
