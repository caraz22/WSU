//Cara Zozokos
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Cards4 {

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

    //method to get different hands for each player
    public static String[] getHand(String[] cards) {
        cards = new String[3];
        for (int i=0; i<3; i++) {
            cards[i] = getCard();
        }

        return cards;
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
    
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        //prompting user for the number of players in the game
        System.out.print("How many players? ");
        int players = in.nextInt();
        while (players <= 2 || players >= 6) { //loop for invalid number entered
            System.out.println("You can have 2-6 players.");
            System.out.print("How many players? ");
            players = in.nextInt();
            if (players >= 2 && players <= 6) {
                break;
            }
        }
        System.out.println();
        System.out.println();

        //initializing the cards array
        String[] cards = new String[3]; 

        //calling a card for the discard pile
        String discard = getCard(); 

        //control boolean for infinite while loop
        boolean done = false; 

        //control boolean for if the current player wants to stick
        boolean lastTime = false; 

            // for (int i=1; i<=players; i++) { //for loop for creating players
            //     CardPlayer playerX = new CardPlayer(i, cards);
            //     String[] playerXHand = getHand(cards);    
            // }    

        while (!done) { //while loop for when game is not done
            CardPlayer playerX = new CardPlayer(1, cards);
            String[] playerXHand = getHand(cards);
            System.out.println(playerX.toString() + ", your hand is " + playerX.displayHand(playerXHand));
            System.out.println("That hand is worth " + playerX.getHandValue(playerXHand) + " points");
            System.out.println("The top discard is " + discard);    

            while(!done) { //while loop for play and card choice
                int choice = getPlayChoice(in);

                if (choice == 1) { //if choosing to stick with hand
                    if (lastTime) { //if alternate player has already made their final move,
                        done = true; //end game
                    } else { //if alternate players have not already made their final move,
                        lastTime = true; //allow them to play their final turn
                    }
                } else {
                    String newCard = "";
                    if (choice == 2) { //if choosing from discard pile
                        newCard = discard;
                    } else { //if choosing to draw a new card
                        newCard = getCard();
                        if (discard.equals("empty")) {
                            System.out.println("The deck is empty!");
                            break;
                        }
                        System.out.println("You drew the " + newCard);
                    }

                    //getting card replacement choice
                    int cardChoice = getCardChoice(in) - 1;
                    if (cardChoice >= 0) {
                        playerX.replaceCard(cardChoice, newCard);
                    }
                    if (lastTime) { //end game
                        done = true;                        
                    }
                }    
                System.out.println();
                System.out.println();    
                break; //breaking out of the most inner loop      
            }                   
        }

        in.close();
    }
    //identified problems with code:
    //players hand not what it should be in next turn
    //discard is not changing based on players choices
    //if game last turn is true after player 1 goes, player 1 doesnt get another turn
    //no end of game points calculator
}
