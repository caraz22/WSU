//import java.util.*;

public class Review {

    public static void main(String[] args) {
        PlayerReview p1 = new PlayerReview("Bob", 4);
        PlayerReview p2 = new PlayerReview("Bob", 4);

        if (p1.equals(p2)) {
            System.out.println("They are the same");
        } else {
            System.out.println("They are different");
        }
        
        /*
        ArrayList<PlayerReview> players = new ArrayList<>();
        players.add(new PlayerReview("Bob", 4));
        players.add(new PlayerReview("Chris", 7));
        players.add(new PlayerReview("Anne", 5));
        System.out.println(players);
        Collections.sort(players);
        System.out.println(players);
        */

        /*
        int x = 42;
        int[] arr = {1, 1, 1, 1, 1,};
        System.out.println("x = " + x);
        System.out.println(Arrays.toString(arr));
        foo(x, arr);
        System.out.println("x = " + x);
        System.out.println(Arrays.toString(arr));
    }

    public static void foo(int x, int[] arr) { //changes to arrays in methods stick, primitave variables  do not
        x = 2;
        arr[0] = 2;
    }
    */

    int x = 1;
    int z = 0;
    switch (x) {
        case 1:
            z = 2;
            break;
        case 2:
            z = 4;
            break;
        default:
            z = -1;
    }

    System.out.println(z);
    }
    
}
