package FileIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class FileIOObjectInputStreamObjectOutputStream {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream("objectoutput.bin"));

        objectObject.writeInt(1234);
        objectObject.writeDouble(3.1415);
        
        objOutput.writeObject(new Student("Alex", "W", 1000));
        objOutput.writeObject(new Student("Chris", "W", 1000));
        objOutput.writeObject(new Student("Grant", "Z", 1000));

        objOutput.close();

        //Read

        ObjectInputStream objInput = new ObjectInputStream(new FileInputStream("objectoutput.bin"));
        int a = objInput.readInt();
        double b = objInput.readDouble();

        System.out.println(a);
        System.out.println(b);

        Student s = (Student) (objInput.readObject());
        System.out.println(s);
        s = (Student) (objInput.readObject());
        System.out.println(s);
        s = (Student) (objInput.readObject());
        System.out.println(s);

        objInput.close();
    }
}

class Student implements Serializable { //key point; marker interface

    private String first;
    private String last;
    private int id;

    public Student(String first, String last, int id) {
        this.first = first;
        this.last = last;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "first=" + first + ", last=" + last + ", id=" + id + ")";
    }
}
