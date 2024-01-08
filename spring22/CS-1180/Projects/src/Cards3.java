//Cara Zozokos
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Cards3 {

    //method to state what the hand is
    public static void displayHand(String[] cards) {
        System.out.print("Your hand is ");
        for (String card : cards) {
            System.out.print(card + " ");            
        }
        System.out.println();
	}

    private static ArrayList<String> deck = null;

    //method for getting each card in the hand
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

    //method to find the value of the face cards
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

    //method to identify the location of the suit for each card
    public static char suitOfCard(String card) {
        char suit = card.charAt(card.length() - 1);
        return suit;
    }

    //points calculator
    public static int getHandValue(String[] cards) {
        int totalPoints = 0;

        char suit1 = suitOfCard(cards[0]);
        char suit2 = suitOfCard(cards[1]);
        char suit3 = suitOfCard(cards[2]);

        int points1 = valueOfRank(cards[0]);
        int points2 = valueOfRank(cards[1]);
        int points3 = valueOfRank(cards[2]);

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
        } else if (points1 >= points2 && points1 >= points3) {
            totalPoints = points1;
        } else if (points2 >= points1 && points2 >= points3) {
            totalPoints = points2;
        } else if (points3 >= points1 && points3 >= points2) {
            totalPoints = points3;
        }

        return totalPoints;

    }

    //method to prompt the user to enter 1, 2, or 3, loops if invalid number is entered
	public static int getPlayChoice(Scanner in) {
        int num = 0;
        while (num < 1 || num > 3) {
            System.out.print(
                    "Do you want to 1) stick with this hand, 2) pick up the top discard or 3) draw a new card? ");
            num = in.nextInt();
            if (num < 1 || num > 3) {
                System.out.println(num + " is not a valid choice");
            }
        }
        return num;
	}

    //method to prompt the user to enter 0, 1, 2, or 3, loops if invalid number is entered
	public static int getCardChoice(Scanner in) {
        int ridOf = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Which of your current cards do you want to get rid of (1, 2 or 3)?");
            System.out.print("If you want to keep all of your current cards and get rid of the new one, enter 0. ");
            ridOf = in.nextInt();
            if (ridOf == 1 || ridOf == 2 || ridOf == 3 || ridOf == 0) {
                isValid = true;
            } else {
                System.out.println(ridOf + " is not a valid choice");
            }
        }
        return ridOf;
    }
    
    //method to get different hands for each player
    public static String[] getHand(String[] cards) {
        cards = new String[3];
        for (int i=0; i<3; i++) {
            cards[i] = getCard();
        }

        return cards;
    }
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //initializing the cards array
        String[] cards = new String[3];
        
        //calling the getHand method 
        String[] player1 = getHand(cards);
        String[] player2 = getHand(cards);
        
        //calling a card for the discard pile
        String discard = getCard();

        //initializing points variables
        int totalPoints = 0;
        int points1 = 0;
        int points2 = 0;

        //initializing turns variable
        int turns = 0;

        //control boolean for infinite while loop
        boolean done = false;

        //control boolean for if the current player wants to stick with their current hand
        //and let the other player go
        boolean lastTime = false;

        while (!done) { //while loop for when the game is not done

            //creating a boolean for player 1's turn
            boolean player1Turn = true;
            //to avoid repeating "turns % 2 == 0" each time
            if (turns % 2 == 0) {
                player1Turn = true; //if true, player 1's turn
            } else {
                player1Turn = false; //if false, player 2's turn
            }

            //"It is Player X's turn"
            //assign the cards hand to whoever's turn it is
            if (player1Turn) { 
                System.out.println("It is Player 1's turn");
                cards = player1;
            } else {
                System.out.println("It is Player 2's turn");
                cards = player2;
            }

            //calling displayHand method to, well, display the hand
            displayHand(cards);

            //calling the getHandValue method
            totalPoints = getHandValue(cards);
            if (player1Turn) { //assigning points value to player 1
                points1 = totalPoints;
            } else { //assigning points value to player 2
                points2 = totalPoints;
            }

            System.out.println("That hand is worth " + totalPoints + " points");
            System.out.println("The top discard is " + discard);
            
            int choice = getPlayChoice(in);

            if (choice == 1) { //if choosing to stick with hand
                turns++;
				if (lastTime) { //if alternate player has already made their final move,
					done = true; //end game
				} else { //if alternate player has not already made their final move,
					lastTime = true; //allow them to play their final turn
				}
            } else {
                turns++;
            
                String newCard = "";
                if (choice == 2) { //if choosing from discard pile
                    newCard = discard; 
                } else { //if choosing to draw a new card
                    newCard = getCard();
                    if (discard.equals("empty")) {
                        System.out.println("The deck is empty!");
                        turns--;
                        break;
                    }
                    System.out.println("You drew the " + newCard);
                }
            
                //with a new card, the player chooses whether to discard it 
                //or replace a current card
                int cardChoice = getCardChoice(in)-1;

                if (cardChoice >= 0) { //player chooses to replace a current card
                    discard = cards[cardChoice];
                    cards[cardChoice] = newCard;
                }
                
                if (lastTime) { //end game
                    done = true;
                }
            }

            //creating space to make output easier to follow
            System.out.println();
            System.out.println();
        }
    
        //stating each player's points
        System.out.println("Player 1 had " + points1 + " points");
        System.out.println("Player 2 had " + points2 + " points");
        //mini points calculator to determine winner
        if (points1 > points2) {
            System.out.println("Player 1 wins!");
        } else if (points1 < points2) {
            System.out.println("Player 2 wins!");
        } else { //if one's not greater than the other (tied), it is a draw
            System.out.println("It is a draw.");
        }

        in.close();
    }

}