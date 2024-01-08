// package Lists;

// import java.util.ArrayList;
// import java.util.List;

// public class WildCards {
    
//     public static void main(String[] args) {

//         display(new ArrayList<Pet>());

//         display2(new ArrayList<Pet>());
//         display2(new ArrayList<Dog>());
//         display2(new ArrayList<String>());

//         List<Bulldog> bulldog = new ArrayList<>();
//         List<?> anydog = bulldog;

//         bulldog.add(new Bulldog());

//         anydog.add(null);
//     }

//     public static void display(List<Pet> list) {
//         for (Pet p : list)
//             System.out.println(p);
//     }

//     public static void display2(List<?> list) {
//         for (int i = 0; i < list.size(); i++) {
//             System.out.println(list.get(i));
//         }
//     }
// }

// class Cat extends Pet {

// }

// class Persian extends Cat {

// }