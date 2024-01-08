//Cara Zozokos
import java.util.Scanner;

class Three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("What was your ACT score? ");
        int act = in.nextInt();

        System.out.print("Did you have perfect attendance? ");
        String pAtt = in.next();

        System.out.print("What was the top GPA in your class? ");
        double tGpa = in.nextDouble();

        System.out.print("What was your GPA? ");
        double gpa = in.nextDouble();

        if (act > 26) {
            System.out.println("You are eligible for honors.");
        } else if (act < 27 && pAtt.equals("yes") && gpa >= (tGpa * 0.9)) {
            System.out.println("You are eligible for honors.");
        } else {
            System.out.println("You are not eligible for honors");
        }

        
        in.close();
    }
}