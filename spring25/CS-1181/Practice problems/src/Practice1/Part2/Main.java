package Part2;
public class Main {

    public static void main(String[] args) {
        
        User user1 = new User("Michelle", "12345");
        System.out.println("1. " + user1.isValidPassword()); // false -- less than 8 characters

        User user2 = new User("Michelle", "12345Michelle");
        System.out.println("2. " + user2.isValidPassword()); // false -- contains username

        User user3 = new User("Michelle", "12345678");
        System.out.println("3. " + user3.isValidPassword()); // true

        System.out.println("4. " + user2.authenticate("ABCDE")); // false -- incorrect password
        System.out.println("5. " + user2.authenticate("12345Michelle")); // true 

        System.out.println("6. " + user3.authenticate("12345678")); // true
    }

}
