import java.util.Scanner;

public class Test { // java classes are typically first letter capitalized

    public static void main(String[] args) { // this will always be the main function literally

        String str = "Hi Sam"; // don't forget semi-colons!
        int num = 420; 
        boolean trueFalse = true; 
        // if you create a variable and don't use it, you'll usually get a warning (at least in in VS code), this won't cause a compile error tho
        // Java requires data type when creating variables, for some reason String is always capitalized but most others are not

        System.out.println(str); // always creats second line (like "\n" if u remember that)
        Scanner in = new Scanner(System.in); // Scanners must be imported (at the top), most things that aren't basic like strings or integers will need to be imported like ArrayLists etc.
        System.out.print("This is a prompt, say something nice! "); // will NOT create a new line, usually used for prompting user input
        String userInput = in.nextLine(); // or in.next() if you don't want a new line, like System.out.println vs System.out.print
        System.out.println("Here is what you said, I hope it was nice! " + userInput);
        System.out.print("Pick a number, any number: ");
        int userNum = in.nextInt(); // different data types of different ".next..."
        // example of a character: v
        // char userChar = in.next().charAt(0); // characters think they're special or smth (i had to look this up bc i didn't remember lol)
        System.out.println("Wow, I love the number " + userNum + "!");

        in.close(); // remember to close the scanner! if you don't, code will compile but you'll most likely have a warning
    }

    // any other functions are outside of main (i think java usually calls them methods)
}