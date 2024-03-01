package Serializable;

import java.io.Serializable;
//objects must implement the Serializable interface
//this "serializable" inteface has no method defined; called a marker interface
//only objects that support the java.io.Serializable interface can be written to streams

class Student implements Serializable {
    
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
        return ("Student{" + "first=" + first + ", last=" + last +", id=" + id);
    }
}
