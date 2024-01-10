import java.util.Scanner;

public class Expenses {
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("What semester is it? ");
        String semester = in.next().toUpperCase();

        int rent = 425;
        int gasElectric = 60;
        int internet = 35;
        int groceries = 160;

        int venmo = rent + gasElectric - internet;

        int sharedExpenses = rent + gasElectric + internet + groceries;
        System.out.println("Your shared monthly expenses are about $" + sharedExpenses);

        double xbox = 16.15;
        double amazon = 14.99;
        double pearson = 16.00;
        double spotifyHulu = 4.99;
        if (semester.equals("SU22")) {
            pearson = 0;
        }
        double addedExpenses = xbox + amazon + pearson + spotifyHulu;
        System.out.println("Your additional monthly expenses are $" + addedExpenses);

        double totalMonthly = sharedExpenses + addedExpenses;
        System.out.println("Your total monthly expenses are about $" + totalMonthly);

        int spendingMoney = 800 - (int)totalMonthly;
        System.out.println("You can spend about $" + spendingMoney + " on whatever you want each month");

        double mayBalance = 3012.42;
        System.out.println("With the $1400 COVID relief fund, your bank account on 5/9/22 is $" + mayBalance);
        
        System.out.println("You need to venmo Avery $" + venmo + " each month");

        in.close();
    }
}
