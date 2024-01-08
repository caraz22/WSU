//Cara Zozokos

import java.util.Scanner; 

public class Five {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        System.out.print("What is the value of n? ");
        int n = in.nextInt();
        if (n < 0) {
            System.out.println("Error: n cannot be negative");
        }
        /*
        boolean prime = true;
        
        for (int i=2; i>0; i++) {       
            for (int j=2; j>0; j++) {
                if (i == 2) {
                    prime = true;
                } else if (i % j == 0) {
                    prime = false;
                    break;
                } else if (i % j != 0) {
                    prime = true;
                } 
                
            }
        }
        
        System.out.print("Enter a number: ");
        int anyNum = in.nextInt();

        for (int i=2; i>0; i++) {  
            if (anyNum == 2) {
                System.out.println("The number you entered is a prime number.");
                break;
            } else if (anyNum % i == 0) {
                System.out.println("The number you entered is not a prime number.");
                break;
            } else {
                System.out.println("The number you entered is a prime number.");
                break;
            }
        }
        */
        in.close();
    }
    
}