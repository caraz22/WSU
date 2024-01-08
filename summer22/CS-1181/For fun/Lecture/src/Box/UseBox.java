package Box;

//import javafx.util.Pair;

public class UseBox {
    
    public static void main(String[] args) {

        // Box<Integer> intBox = new Box<>();
        Box<String> stringBox = new Box<String>();

        stringBox.put("one");
        //stringBox.put(1); //error
        System.out.println(stringBox.get());
        String s = stringBox.get();
        System.out.println(s);

        //Pair<U, V>
        // Pair<String, Integer> siPair;
        // siPair = new Pair<>("one", 1);
        //System.out.println(siPair);

        //ArrayList<Integer> listInt = new ArrayList
    }
}
