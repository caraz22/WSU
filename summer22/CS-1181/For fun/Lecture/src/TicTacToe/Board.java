package TicTacToe;

public class Board {
    
    //The TicTacToe Board is a two dimensional array of characters
    private char[][] squares;

    //This is the constructor -- it should initialize the squares array
    //so that it looks like this:
    //1 2 3
    //4 5 6
    //7 8 9
    //But those values need to be chars NOT ints (since eventually we need
    //to store X's and O's in those spots) 
    public Board() {

        //This creates the two-dimensional array. the keyword "new" allocates
        //the memory to store the array. the keyword "char" is because the
        //array will store characters. The first [3] is because the array
        //has three rows, and the second [3] is because it has three columns
        squares = new char[3][3];

        //k is a counter that we will use to add 1, 2, 3, ... 9
        //to the array slots
        int k = 1;

        //These two for loops are common when we need to do something with
        //every slot in a two-dimensional array. In fact, they are so common,
        //you might want to put them in a "cookbook" or notes sheet for this
        //course, so that you can find them if you need to deal with a 2D
        //array at some point. The outer for loop controls what row we are
        //on, and the inner one controls what column we are on.
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {

                //This is a kludge. It is a shortcut way to convert the integer
                //k to a character, which is necessary because the squares array
                //stores chars, not ints. The "" + k part adds the int value of k
                //to an empty string, which effectively converts k from an int to a
                //String. Then the .charAt(0) part gets the first character of that 
                //String, which is what we want to store in the 2D array. If this
                //part is confusing, don't worry too much about it -- it doesn't
                //come up a lot
                this.squares[i][j] = ("" + k).charAt(0);
                k++;
            }
        }
    }

    //This method records a move onto the TTT board. For example, if the method
    //is called like this:
    //recordMove('X', 5)
    //that would put X in the center square.
    //The only valid symbosl are X and O, and the only valid squares are 1-9
    public boolean recordMove(char symbol, int square) {

        //check for an invalid square number
        if (square < 1 || square > 9) {
            return false;
        }

        int row = (square - 1) / 3;
        int col = (square - 1) % 3;

        //if there is already an X or O at this location, the move is not valid
        if (squares[row][col] == 'X' || squares[row][col] == 'O') {
            return false;
        }

        //otherwise, we can put the symbol at that location
        squares[row][col] = symbol;
        return true;
    }

    //This method should return the correct value for each of these circumstances:
    //X if X has TTT
    //O if O has TTT
    //T if the game is a tie
    //N if the game is not yet over
    public char getGameState() {

        //First we will check for a horizontal TTT
        for (int i = 0; i < squares.length; i++) { //Loops over each row of the board
            //This checks to see if the thing in the 0th (left) column of this row is equal
            //to the thing in the 1st (middle) column and if the thing in the middle column
            //is the same as the thing in the 2nd (right) column. If that is the case, whichever
            //symbol is involved (X or O) has TTT, so we should return that symbol
            if (squares[i][0] == squares[i][1] && squares[i][1] == squares[i][2]) {
                return squares[i][0];
            }
        }

        //This does the exact same thing, but for a vertical TTT 
        //(so the columns and rows are reversed)
        for (int i = 0; i < squares.length; i++) {
            //This checks to see if the thing in the 0th (top) row of this column is equal
            //to the thing in the 1st (middle) row and if the thing in the middle row is the
            //same as the thing in the 2nd (bottom) row.
            if (squares[0][i] == squares[1][i] && squares[1][i] == squares[2][i]) {
                return squares[0][i];
            }
        }

        //This checks for a diagonal TTT, upper left, middle, lower right
        if (squares[0][0] == squares [1][1] && squares [1][1] == squares[2][2]) {
            return squares[1][1];
        }

        //Now we need to check if the game is a tie. This is the case if every square
        //of the board contains either an X or an O
        boolean tie = true;
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (squares[i][j] != 'X' && squares[i][j] != 'O') {
                    tie = false;
                }
            }
        }
        
        if (tie) {
            return 'T';
        }

        //If X doesnt have TTT and O doesn't have TTT and the game isn't a tie, then
        //the game is not yet over, so we return N
        return 'N';
    }

        //This method creates a String representation of the TTT board
        @Override
        public String toString() {

            //We start by initializing an empty String
            String returnString = "";
        

            //Then we look at each square on the board, using the same nested loop
            //we saw in the constructor.
            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {
                    //For each square of the board, we add the character in that square to the
                    //string, and then add a tab (that is what \t is).
                    returnString += squares[i][j] + "\t";
                }
            //At the end of each row in the board, we add two new line (enter) characters.
            //This is what \n is for.
            returnString += "\n\n";
        }

        //Then we return our string representation of the board. Note that a toString
        //method should ALWAYS create and return a String. It should NEVER call
        //System.out.println inside this method
        return returnString;
    }
}
