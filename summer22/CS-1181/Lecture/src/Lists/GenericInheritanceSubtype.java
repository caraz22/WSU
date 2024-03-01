// package Lists;

// public class GenericInheritanceSubtype {
    
//     public static void main(String[] args) {

//         Cage<Pet> petCage = new Cage<>();

//         Cage<Dog> dogCage = new Cage<>();

//         //petCage = dogCage;

//         petCage.put(new Dog());
//         petCage.put(new Bulldog());
//     }
// }

// class Pet {
//     public void petShow() {

//     }
// }

// class Dog extends Pet {
//     public void dogBark() {

//     }
// }

// class Bulldog extends Dog {
//     public void bulldogSnarl() {

//     }
// }

// class Cage<T> {

//     private T pet;

//     public void put(final T pet) {
//         this.pet = pet;
//     }
// }