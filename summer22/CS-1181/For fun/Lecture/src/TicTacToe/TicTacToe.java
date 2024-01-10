package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    
    public static Scanner in = new Scanner(System.in);

    public static Player createPlayer(char symbol) {
        Player p;
        System.out.println("Is this player a 1) human or a 2) computer? ");
        int answer = in.nextInt();
        in.nextLine(); //throw away the <enter> from after the int
        if(answer == 1) {
            System.out.print("What is this player's name? ");
            String p1Name = in.nextLine();
            p = new HumanPlayer(p1Name, symbol);
        } else {
            p = new ComputerPlayer("HAL", symbol);
        }
        return p;
    }

    public static void main(String[] args) {

        //Creates the players
        Player p1 = createPlayer('X');
        Player p2 = createPlayer('O');

        //Creates the game board
        Board gameBoard = new Board();

        //"theirTurn" holds the player object whose turn it is
        Player theirTurn = p1;

        //While the game is not yet over
        while(gameBoard.getGameState() == 'N') {

            //Print out the board and let the player move
            System.out.println(gameBoard);
            theirTurn.move(gameBoard);

            //Switch whose turn it is
            if (theirTurn == p1) {
                theirTurn = p2;
            } else {
                theirTurn = p1;
            }
        }

        //We only get here when the game is over (because X or O won or 
        //there was a tie) -- find out which one of those happened
        char gameResult = gameBoard.getGameState();

        //Congratulate the winner, if applicable, and update both players' records
        switch (gameResult) {
            case 'X':
                System.out.println("Congratulations, " + p1.getName() + "!");     
                p1.recordWin();
                p2.recordLoss();
                break;
            case 'O':
                System.out.println("Congratulations, " + p2.getName() + "!");
                p2.recordWin();
                p1.recordLoss();
                break;
            case 'T':
                System.out.println("You are evenly matched!");
                p2.recordTie();
                p1.recordTie();
                break;
        }

        //Show the players' new records
        System.out.println(p1);
        System.out.println(p2);
    }
}
