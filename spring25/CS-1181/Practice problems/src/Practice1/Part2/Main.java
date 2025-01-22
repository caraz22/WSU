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

        SecureUser su = new SecureUser("Michelle", "hello123");
        System.out.println("Password validity: " + su.isValidPassword());
        System.out.println("Attempt 1: " + su.authenticate("hello"));
        System.out.println("Attempt 2: " + su.authenticate("hello12"));
        System.out.println("Attempt 3: " + su.authenticate("Hello123"));
        System.out.println("Attempt 4: " + su.authenticate("hello123"));

        SecureUser su2 = new SecureUser("Cara", "world456");
        System.out.println("Password validity: " + su2.isValidPassword());
        System.out.println("Attempt 1: " + su2.authenticate("world"));
        System.out.println("Attempt 2: " + su2.authenticate("world123"));
        System.out.println("Attempt 3: " + su2.authenticate("world456"));
        System.out.println("Attempt 4: " + su2.authenticate("world654"));
        System.out.println("Attempt 5: " + su2.authenticate("wrong1"));
        System.out.println("Attempt 6: " + su2.authenticate("wrong2"));
        System.out.println("Attempt 7: " + su2.authenticate("wrong3"));
        System.out.println("Attempt 8: " + su2.authenticate("wrong4"));
        System.out.println("Attempt 9: " + su2.authenticate("world456"));

        SecureUser su3 = new SecureUser("John", "John7890");
        System.out.println("Password validity: " + su3.isValidPassword());
        System.out.println("Attempt 1: " + su3.authenticate("john"));
        System.out.println("Attempt 2: " + su3.authenticate("John7890"));
    }

}
