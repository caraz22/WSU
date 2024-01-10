
//Cara Zozokos
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Cards2 {

    private static ArrayList<String> deck = null;

    // method to call card
    public static String getCard() {

        if (deck == null) {
            deck = new ArrayList<>();
            String[] suits = { "H", "D", "C", "S" };
            String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9",
                    "10", "J", "Q", "K", "A" };
            for (String suit : suits) {
                for (String rank : ranks) {
                    deck.add(rank + suit);
                }
            }
            Collections.shuffle(deck);
        }

        if (deck.size() == 0) {
            return "empty";
        } else {
            String card = deck.get(0);
            deck.remove(0);
            return card;
        }
    }

    // method to get the value of the rank of the card
    public static int valueOfRank(String card) {
        String rank = card.substring(0, card.length() - 1);
        char dig = rank.charAt(0);
        int value = 0;
        if (Character.isDigit(dig)) {
            value = Integer.parseInt(rank);
        } else if (rank.equals("A")) {
            value = 11;
        } else if (rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
            value = 10;
        }

        return value;
    }

    // method to identify the suit of the card
    public static char suitOfCard(String card) {
        char suit = card.charAt(card.length() - 1);
        return suit;
    }

    public static int getHandValue(String card1, String card2, String card3) {
        int totalPoints = 0;

        char suit1 = suitOfCard(card1);
        char suit2 = suitOfCard(card2);
        char suit3 = suitOfCard(card3);

        // calling the valueOfRank(String card) method
        int points1 = valueOfRank(card1);
        int points2 = valueOfRank(card2);
        int points3 = valueOfRank(card3);

        // totalPoints calculator
        if (suit1 == suit2 && suit2 == suit3) {
            totalPoints = points1 + points2 + points3;
        } else if (suit1 == suit2) {
            totalPoints = points1 + points2;
            if (totalPoints < points3) {
                totalPoints = points3;
            }
        } else if (suit1 == suit3) {
            totalPoints = points1 + points3;
            if (totalPoints < points2) {
                totalPoints = points2;
            }
        } else if (suit2 == suit3) {
            totalPoints = points2 + points3;
            if (totalPoints < points1) {
                totalPoints = points1;
            }
        } else if (points1 > points2 && points1 > points3) {
            totalPoints = points1;
        } else if (points2 > points1 && points2 > points3) {
            totalPoints = points2;
        } else if (points3 > points1 && points3 > points2) {
            totalPoints = points3;
        }

        return totalPoints;

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // calling the getCard() method for each card
        String card1 = getCard();
        String card2 = getCard();
        String card3 = getCard();

        // calling the getCard() method for the top of the discard pile
        String discard = getCard();

        // initializing the totalPoints variable
        int totalPoints = 0;

        // initializing the turns variable
        int turns = 1;

        while (true) {
            // stating the given hand
            System.out.println("Your hand is " + card1 + " " + card2 + " " + card3);

            // calling the suitOfCard(String card) method
            totalPoints = getHandValue(card1, card2, card3);

            // Stating the worth of the hand's points
            System.out.println("That hand is worth " + totalPoints + " points");

            // Stating the top of the discard pile
            System.out.println("The top discard is " + discard);

            // Creating a loop prompting the user to choose option 1, 2 or 3, and repeating
            // if the input is invalid
            int num = 0;
            while (num < 1 || num > 3) {
                System.out.print(
                        "Do you want to 1) stick with this hand, 2) pick up the top discard or 3) draw a new card? ");
                num = in.nextInt();
                // prompt outside of loop first?
                if (num < 1 || num > 3) {
                    System.out.println(num + " is not a valid choice");
                }
            }

            String newCard = "";
            if (num == 2) {
                newCard = discard;
            } else if (num == 3) {
                // calling a new card for the top of the discard pile
                newCard = getCard();
                if (discard.equals("empty")) {
                    System.out.println("The deck is empty!");
                    break;
                }
                // Stating called card
                System.out.println("You drew the " + newCard);
            } else if (num == 1) {
                // Stating the final hand and its points value
                break;
            }

            // implementing this statement to be printed on a loop after each option is
            // picked or if input is invalid
            num = 0;
            int ridOf = -1;
            boolean isValid = false;
            while (!isValid) {
                System.out.println("Which of your current cards do you want to get rid of (1, 2 or 3)?");
                System.out.print(
                        "If you want to keep all of your current cards and get rid of the new one, enter 0. ");
                ridOf = in.nextInt();
                // if input is invalid, statement is printed out and question is asked again
                if (ridOf == 1 || ridOf == 2 || ridOf == 3 || ridOf == 0) {
                    isValid = true;
                } else {
                    System.out.println(ridOf + " is not a valid choice");
                }
            }

            // instructions for picking option 1, 2, 3 or 0
            if (ridOf == 1) {
                discard = card1;
                card1 = newCard;
            } else if (ridOf == 2) {
                discard = card2;
                card2 = newCard;
            } else if (ridOf == 3) {
                discard = card3;
                card3 = newCard;
            } else if (ridOf == 0) {
                discard = newCard;
            }

            // counting the turns
            turns++;

        }
        // Printing the final output, ending the program.
        System.out.println("Your hand is " + card1 + " " + card2 + " " + card3);
        // Stating the worth of the hand's points
        System.out.println("That hand is worth " + totalPoints + " points");

        // Stating the top of the discard pile
        System.out.println("The top discard is " + discard);
        System.out.println("You played " + turns + " turns");

        in.close();
    }

}