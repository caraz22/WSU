package Lists;

import java.util.ArrayDeque;

public class UseStack {
    
    public static void main(String[] args) {

        ArrayDeque<Student> stack = new ArrayDeque<>();

        stack.push(new Student("Chris", 1010, 4.0));
        stack.push(new Student("Alex", 1003, 3.0   ));
        stack.push(new Student("Grant", 1006, 4.0));
        stack.push(new Student("Nathan", 1005, 3.2));
    }
}
