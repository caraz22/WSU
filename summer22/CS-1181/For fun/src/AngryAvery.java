import java.util.Scanner;

public class AngryAvery {

    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);

        System.out.println("What game should we play? (realistically, we only play two together)");
        String game = in.nextLine().toLowerCase();
        System.out.println("Is Avery high? (yes or no)");
        String highStatus = in.nextLine().toLowerCase();

        if (game.equals("apex legends") || game.equals("apex")) {
            if (highStatus.equals("yes")) {
                Avery happyApex = new Avery(highStatus, game);
                happyApex.getApexGames();
            } else {
                Avery angryApex = new Avery(highStatus, game);
                angryApex.getApexGames();
            }
        }

        if (game.equals("raft")) {
            if (highStatus.equals("yes")) {
                Avery happyRaft = new Avery(highStatus, game);
                happyRaft.getRaftEvents();
            } else {
                Avery angryRaft = new Avery(highStatus, game);
                angryRaft.getRaftEvents();
            }
        }

        in.close();
    }
}