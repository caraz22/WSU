package FileIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;

public class FileIOStreamDataOutputStream {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.println("write bytes to file --");
        OutputStream out = new FileOutputStream("output.bin");
        out.write(255);
        out.close();

        System.out.println("Read bytes from file");

        InputStream in = new FileInputStream("output.bin");
        int data = in.read();
        System.out.println(data);
        in.close();

        System.out.println("write primitive data to file");
        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("output2.bin"));
        dataOut.writeDouble(12.5);
        dataOut.writeInt(13);
        dataOut.writeBoolean(true);
        dataOut.close();
        System.out.println("==============");

        System.out.println("read primitive data from file");
        /*
        DataInputStream dataIn = new DataInputStream(new FileInputStream("output2.bin"));

        double tempDouble = dataIn.readDouble();
        System.out.println(tempDouble);

        int tempInt = dataIn.readInt();
        System.out.println(tempInt);

        boolean tempBoolean = dataIn.readBoolean();
        System.out.println(tempBoolean);
        dataIn.close();
        */
    }
}
