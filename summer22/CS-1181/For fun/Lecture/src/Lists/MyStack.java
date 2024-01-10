package Lists;

public class MyStack {
    
    private int arr[];
    private int top;
    private int capacity;

    MyStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1; //or return size() == 0;
    }

    public boolean isFull() {
        return top == capacity - 1; //return size() == capacity;
    }

    public void push(int e) {
        if(isFull()) {
            System.out.println("The stack is full.");
            System.exit(-1);
        }

        System.out.println("Push " + e);
        arr[++top] = e;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("The stack is empty.");
            System.exit(-1);
        }

        System.out.println("Pop " + arr[top]);
        return arr[top--];
    }

    public int peek() {
        if(!isEmpty()) {
            return arr[top];
        } else {
            System.exit(-1);
        }

        return -1;
    }

    public int search(int o) {
        int distance = -1;
        for(int i = 0; i <= top; i++) {
            if (arr[i] == o) {
                distance = top - i + 1;
                break;
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(3);

        stack.push(1);
        stack.push(2);

        System.out.println("distance 1 " + stack.search(1));

        System.out.println("size " + stack.size());
        stack.pop();
        stack.pop();

        stack.push(3);
        stack.peek();

        System.out.println("peek " + stack.peek());
        System.out.println("Empty " + stack.isEmpty());
    }
}
