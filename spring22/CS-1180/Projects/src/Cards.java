//Cara Zozokos
import java.util.Scanner;

public class Cards {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //Prompting the user for a hand of three cards, making any characters uppercase
        System.out.print("Enter your hand, separated by spaces. ");
        String hand = in.nextLine().toUpperCase();
        
        //Separate cards into separate strings
        String parse[] = hand.split(" ");
        String card1 = parse[0];
        String card2 = parse[1];
        String card3 = parse[2];

        //Identifying the value of the rank of card 1, keeping 10 in mind
        String rank1 = card1.substring(0, card1.length() - 1);
        char dig1 = rank1.charAt(0);
        int value1 = 0;
        if (Character.isDigit(dig1)) {
            value1 = Integer.parseInt(rank1);
        }

        //Assigning point values to the face cards for card 1
        //Outputting invalid rank if rank of card 1 is not 2-10 or A, J, Q, or K
        //Terminating program if invalid rank
        if (rank1.equals("A")) {
            value1 = 11;
        } else if (rank1.equals("J") || rank1.equals("Q") || rank1.equals("K")) {
            value1 = 10;
        } else if (value1 >= 2 && value1 <= 10) {
            value1 = Integer.parseInt(rank1);
        } else {
            System.out.println("Invalid rank for card 1");
            System.exit(0);
        }

        //Identifying the value of the rank of card 2, keeping 10 in mind
        String rank2 = card2.substring(0, card2.length() - 1);
        char dig2 = rank2.charAt(0);
        int value2 = 0;
        if (Character.isDigit(dig2)) {
            value2 = Integer.parseInt(rank2);
        }

        //Assigning point values to the face cards for card 2
        //Outputting invalid rank if rank of card 2 is not 2-10 or A, J, Q, or K
        //Terminating program if invalid rank
        if (rank2.equals("A")) {
            value2 = 11;
        } else if (rank2.equals("J") || rank2.equals("Q") || rank2.equals("K")) {
            value2 = 10;
        } else if (value2 >= 2 && value2 <= 10) {
            value2 = Integer.parseInt(rank2);
        } else {
            System.out.println("Invalid rank for card 2");
            System.exit(0);
        }
        
        //Identifying the value of the rank of card 3, keeping 10 in mind
        String rank3 = card3.substring(0, card3.length() - 1);
        char dig3 = rank3.charAt(0);
        int value3 = 0;
        if (Character.isDigit(dig3)) {
            value3 = Integer.parseInt(rank3);
        }        

        //Assigning point values to the face cards for card 3
        //Outputting invalid rank if rank of card 3 is not 2-10 or A, J, Q, or K
        //Terminating program if invalid rank        
        if (rank3.equals("A")) {
            value3 = 11;
        } else if (rank3.equals("J") || rank3.equals("Q") || rank3.equals("K")) {
            value3 = 10;
        } else if (value3 >= 2 && value3 <= 10) {
            value3 = Integer.parseInt(rank3);
        } else {
            System.out.println("Invalid rank for card 3");
            System.exit(0);
        }

        //Identifying location of suit1
        char suit1 = card1.charAt(card1.length() - 1);

        //Creating a variable for card 1's amount of points
        int points1 = 0;

        //Assigning the suits, outputting invalid suit if suit of card 1 is not S, H, C, or D
        //Terminating program if invalid suit
        if (suit1 == 'S' || suit1 == 'H' || suit1 == 'C' || suit1 == 'D') {
            points1 = value1;
        } else {
            System.out.println("Invalid suit for card 1");
            System.exit(0);
        }

        //Identifying location of suit2
        char suit2 = card2.charAt(card2.length() - 1);

        //Creating a variable for card 2's amount of points
        int points2 = 0;

        //Assigning the suits, outputting invalid suit if suit of card 2 is not S, H, C, or D
        //Terminating program if invalid suit
        if (suit2 == 'S' || suit2 == 'H' || suit2 == 'C' || suit2 == 'D') {
            points2 = value2;
        } else {
            System.out.println("Invalid suit for card 2");
            System.exit(0);
        }
        
        //Identifying location of suit3
        char suit3 = card3.charAt(card3.length() - 1);

        //Creating a variable for card 3's amount of points
        int points3 = 0;

        //Assigning the suits, outputting invalid suit if suit of card 3 is not S, H, C, or D
        //Terminating program if invalid suit        
        if (suit3 == 'S' || suit3 == 'H' || suit3 == 'C' || suit3 == 'D') {
            points3 = value3;
        } else {
            System.out.println("Invalid suit for card 3");
            System.exit(0);
        }
        
        

        //Creating a variable for the hand's total point value
        int totalPoints = 0;

        //totalPoints calculator
        if (suit1 == suit2 && suit2 == suit3) {
            totalPoints = points1 + points2 + points3;
        } else if (suit1 == suit2) {
            totalPoints = points1 + points2;
        } else if (suit1 == suit3) {
            totalPoints = points1 + points3;
        } else if (suit2 == suit3) {
            totalPoints = points2 + points3;
        } else if (points1 > points2 && points1 > points3) {
            totalPoints = points1;
        } else if (points2 > points1 && points2 > points3) {
            totalPoints = points2;
        } else if (points3 > points1 && points3 > points2) {
            totalPoints = points3;
        }

        //Printing the output
        System.out.println("That hand is worth " + totalPoints + " points");
    
        in.close();
    }

}
