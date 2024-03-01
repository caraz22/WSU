// package Lists;

// import java.util.ArrayList;
// import java.util.List;

// public class Lists {

//     public static <T> List<T> toList(T... arr) {
//         List<T> list = new ArrayList<>();
        
//         for(T elt: arr)
//             list.add(elt);

//         return list;
//     }
    
//     public static void main(String[] args) {

//         List<Integer> ints = Lists.toList(new Integer[] {1, 2, 3});
//         System.out.println("ints " + ints);

//         List<String> words = Lists.toList("hello", "world", "!");
//         System.out.println(words);
//     }
// }
