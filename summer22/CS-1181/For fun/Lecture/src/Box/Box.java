package Box;

public class Box<T> {

    private T t; //T as type for data field

    public void put(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
