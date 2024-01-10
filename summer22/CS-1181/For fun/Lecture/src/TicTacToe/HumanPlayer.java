package TicTacToe;

public class HumanPlayer extends Player {
    
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void move(Board theBoard) {
        while (true) {
            System.out.print(super.getName() + ", where do you want to move? ");
            int choice = TicTacToe.in.nextInt();
            boolean result = theBoard.recordMove(super.getSymbol(), choice);
            if (result) {
                break;
            }
        }
    }
}
