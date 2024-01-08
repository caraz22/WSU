//Cara Zozokos

public class CardPlayer {
    
    private int playerNumber; //differentiate players
    private String[] cards; //player's current array of cards

    //constructor
    public CardPlayer(int playerNumber, String[] cards) {
        setPlayerNumber(playerNumber);
        setCards(cards);
    }

    //returns a string containing the player's hand
    public String displayHand(String[] cards) {
        String hand = "";
        for (int i=0; i<cards.length; i++) {
            hand += cards[i] + " ";
        }
        return hand;
    }

    //points calculator
    public int getHandValue(String[] cards) {
        int totalPoints = 0;

        char suit1 = getSuit(cards[0]);
        char suit2 = getSuit(cards[1]);
        char suit3 = getSuit(cards[2]);

        int points1 = getRank(cards[0]);
        int points2 = getRank(cards[1]);
        int points3 = getRank(cards[2]);

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

    //replaces chosen card with new card, returns the chosen card just replaced
    public String replaceCard(int old, String newCard) {
        String oldCard = cards[old];
        cards[old] = newCard;

        return oldCard;
    }

    //returns the point value of each number and face card
    private static int getRank(String card) {
        String rank = card.substring(0, card.length() -1);
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

    //returns character representative of the card's suit
    private static char getSuit(String card) {
        char suit = card.charAt(card.length() -1);
        return suit;
    }

    //returns a String in the form of "Player <playerNumber?"
    public String toString() {
        String nameNum = "Player " + playerNumber;
        return nameNum;
    }

    //getters
    public int getPlayerNumber() {
        return playerNumber;
    }
    public String[] getCards() {
        return cards;
    }

    //setters
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
    public void setCards(String[] cards) {
        this.cards = cards;
    }
}
