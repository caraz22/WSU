import java.util.Scanner;

class Loops {
    
    public static void main(String[] args) {
//codingbat.com
        Scanner in = new Scanner(System.in); 

        int n = 5;

        for (int i=0; i<=n; i++) {
            for (int j=0; j<n; j++) {       
                if (j < i) {
                    System.out.print("  ");
                } else {
                System.out.print("* ");
                }
            }
            System.out.println();
        }     
        /*
        //int m = 1;
        int n = 5;

        for (int i=0; i<=n; i++) {
            for (int j=0; j<i; j++) {                
                System.out.print("* ");
            }
            System.out.println();
        }
*/
/*
        //int m = 1;
        int n = 5;

        for (int i=0; i<=n; i++) {
            for (int j=0; j<i; j++) {                
                System.out.print("* ");
            }
            System.out.println();
        }
*/
/*
        int m = 3;
        int n = 5;
        //outer loop = rows
        //inner loop = columns
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }


        int count = 0;
        for (int i=1; i<=5; i++) {
            for (int j=1; j<=3; j++) { 
                if (j % 2 == 0) {
                    continue;
                    //continue restarts the smallest inner loop
                    //break;
                    //break breaks out of the smallest inner loop
                }   
                count++;
            }
        }
        //outer executions * inner executions = # of times inner loop is executed
        //5 * 3 = 15
        System.out.println("The inner loop executed " + count + " times");
    */
/*
        int n = 5;
        // * * * * *
        for (int j=0; j<n; j++) {
            if (j % 2 == 0) {
                for (int i=0; i<n; i++) {
                System.out.print("* ");
                }
            }
            System.out.println();            
        }

        int count = 0;
        //for (double x=0.0; x<1.0; x+=0.5) {
        //don't use a double as a loop control variable!
        for (int x=0; x<10; x+=1) {
            System.out.println(x);
            count ++;
        }
        System.out.println("count = " + count);

        int n = 10;
        int sumToN = 0;

        for (int i=1; i<=n; i++) {
            sumToN += i;
        }
        System.out.println("The sum of the numbers from 1 to " + n + " is " + sumToN);
        //try to rewrite this but without using "for"
*/
/*
        int n = 5;
        int i = 0;
        int sum = 0;

        while(i <= n) {
            sum += i;
            i++;
        }
        System.out.println("The sum is " + sum);

   
        int randNum = 0;
        do {
            randNum = (int) (Math.random() * 6) + 1;
            System.out.println("You rolled a " + randNum);
        } while (randNum != 3);
        // try to rewrite this as a for loop (do not use "while" anywhere)     

        for (int i=0; i!=3; i=(int)(Math.random() * 6) +1) {
            if (i != 0) {
            System.out.println("You rolled a " + i);
            }
        }

        char answer;
        do {
            System.out.print("Do you want to continue? ");
            answer = in.next().charAt(0);
        } while (answer != 'n');

        for (char c = 'y'; c != 'n'; c = in.next().charAt(0)) {
            System.out.print("new version: do you want to continue? ");
            int x = 5;
            if (x < 10) {
                int y = x + 4;
            }
        }
*/
/*
        //guess a number game
        // generate a random number between 1 and 100
        //ask the user to guess the number        
        int secret = (int) (Math.random() * 100) + 1;
        System.out.println(secret);

        int guess = 0;
        //if they get it right, say yay and quit
        //if they are too low or too high, tell them that and have them guess again
        do {
            System.out.print("What is your guess? ");
            guess = in.nextInt();

			if (guess < secret) {
				System.out.println("That is too low.");
			} else if (guess > secret) {
				System.out.println("That is too high.");
			}
		} while (guess != secret);

        System.out.println("Correct!");

    
        //change this to count upwards by 2's from 10 to 30
        for(int i=9; i<=29; i++) { 
         //i=i+2 is the same as 1+=2
        
        //for(int i=10; i>0; i--) {
            System.out.println(i=i+1);
        }
        System.out.println("Blast off!");      

/*
        //prompt the user to enter a number between 1 and 10
        //if they don't follow directions, yell at them and then continue to prompt them
        //when they get it right, say "Thank you."
        
        System.out.print("Enter a number between 1 and 10. ");
        int num = in.nextInt();

        while (num < 1 || num > 10) {
            System.out.println("Wrong, try again. ");
            System.out.print("Enter a number between 1 and 10. ");
            num = in.nextInt();

            if (!(num < 1 || num > 10)) {
                System.out.println("Thank you.");
                break;
            }
        }
*/
        /*
        System.out.print("Do you want to continue (y/n)? ");
        String answer = in.nextLine();

        while (answer.equals("y")) {
            System.out.println("Great, lets continue!");
            System.out.print("Do you want to contnue (y/n)? ");
            answer = in.nextLine();

            if (!(answer.equals("y") || answer.equals("n"))) {
                System.out.println("You're not following directions!!");
                break;
            }
        }

        System.out.println("Goodbye! ");
*/
        in.close();
    }
}
