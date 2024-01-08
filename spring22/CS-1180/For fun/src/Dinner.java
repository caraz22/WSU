import java.util.Scanner;

class Dinner {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("What are we having for dinner tonight? ");
        String dinner = in.nextLine();

        if (dinner.equals("i dont know")) {
            System.out.println("Really?!");
        } else if (dinner.equals("frozen meals")) {
            System.out.println("Okay...");
        } else if (dinner.equals("pizza")) {
            System.out.println("Again??");
        } else if (dinner.equals("tacos")) {
            System.out.println("Sure");
        } else if (dinner.equals("mostaccioli")) {
            System.out.println("I don't know if I'll feel like making it later, but maybe.");
        } else {
            System.out.println("No :)");
        }
        in.close();
    }   
}
