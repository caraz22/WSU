package TicTacToe;

public abstract class Player {
    
    private String name;
    private char symbol; //X or O
    private int wins;
    private int losses;
    private int ties;

    //The constructor initializes the fields of the class. The name
    //and symbol (X or O) are passed in by the code that is creating
    //the player (usually the driver, where the main method is).
    //We're initializing the wins, losses, and ties to 0 and for right now
    //all of our players are humans. Be sure you undetstand the "this"
    //keyword is requried and when it is not -- if you don't know, ask
    //in the helproom, on the CSE discord, in the lab, or in office hours!
    Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        wins = 0;
        losses = 0;
        ties = 0;
    }

    //copy constructor -- makes an independent player object that is
    //initially the same as the other one that is passed in. This is going to
    //be super important for Project 1 -- you need copy constructors to create
    //INDEPENDENT copies, meaning that if you make a change to this player, it
    //won't impact the other one.
    Player(Player other) {
        this.name = other.name;
        this.symbol = other.symbol;
        this.wins = other.wins;
        this.losses = other.losses;
        this.ties = other.ties;
    }

    //This method asks the player where they want to move and tries to move there.
    //Recall that the Board's recordMove method will return false if the move is
    //invalid (like if they enter square number 125 or if they try to move to a square
    //that already has an X or O in int). That's the reason for the while loop -- we
    //keep asking the player where they want to move over and over and trying to move
    //there until the recordMove method returns true, meaning that the move was valid.
    public abstract void move(Board theBoard);

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }
    public char getSymbol() {
        return symbol;
    }

    public void recordWin() {
        wins++;
    }
    public void recordLoss() {
        losses++;
    }
    public void recordTie() {
        ties++;
    }

    public String toString() {
        //Name (wins-losses-ties): symbol
        String returnString = (this.name + " (" + this.wins + "-" + this.losses + "-" + this.ties + "); " + this.symbol);
        return returnString;
    }
}
