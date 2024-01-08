//Cara Zozokos
import java.util.Scanner;

public class Four {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("What is the value of n? ");
        int n = in.nextInt();
        if (n < 0) {
            System.out.println("Error: n cannot be negative");       
        } 

        int v1 = 0;
        int v2 = 1;
        int v3;
        
        for (int i=1; i<=n; i++) {
            if (i == 1) {
                System.out.print("1 ");
            } else {
                v3 = v1 + v2;
                v1 = v2;
                v2 = v3;    
                System.out.print(v3 + " ");
            }
        }
        
        in.close();
    }
    
}
