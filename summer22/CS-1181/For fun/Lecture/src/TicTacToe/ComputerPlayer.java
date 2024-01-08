package TicTacToe;

public class ComputerPlayer extends Player {
    
    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void move(Board theBoard) {
        while (true) {
            int choice = (int) (Math.random() + 9) + 1;
            boolean result = theBoard.recordMove(super.getSymbol(), choice);
            if (result) {
                System.out.println(super.getName() + " moved to " + choice);
                break;
            }
        }
    }
}
