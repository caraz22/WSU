public class MonthlyExpenses {
    
    public static void main(String[] args) {

        double amazonPrime = 24.00;
        double spotify = 4.99;
        double xboxLive = 16.19;        
        double subscriptionCharges = amazonPrime + spotify + xboxLive;
        System.out.println("Your monthly subscriptions are: \n\tAmazon prime - $" + String.format("%.2f", amazonPrime) + "\n\tSpotify - $" + spotify + "\n\tXbox live - $" + xboxLive);
        System.out.println("This adds up to: $" + String.format("%.2f", subscriptionCharges));
        System.out.println();

        double internet = 69.99;
        double minCredPayment = 35.00;
        double rent = 450.00;
        double otherMonthlyCharges = internet + minCredPayment + rent;
        System.out.println("Your other monthly payments are: \n\tSpectrum internet - $" + String.format("%.2f", internet) + "\n\tCredit card minimum monthly payment - $" + String.format("%.2f", minCredPayment) + "\n\tRent (Venmo'd to Avery) - $" + String.format("%.2f", rent));
        System.out.println("This adds up to: $" + String.format("%.2f", otherMonthlyCharges));
        System.out.println();

        double groceryTrip = 85.00;
        double groceriesMonth = groceryTrip * 2;
        System.out.println("You pay for groceries approximately twice a month, adding up to about: $" + String.format("%.2f", groceriesMonth));
        System.out.println();

        double mandatoryMonthlyCharges = subscriptionCharges + otherMonthlyCharges + groceriesMonth;
        System.out.println("Your mandatory monthly expenses come out to be: $" + String.format("%.2f", mandatoryMonthlyCharges));
        System.out.println();

        double loan = 5053.93;
        double monthlyLoan = loan / 4;
        System.out.println("The money you will be getting from the loan is: $" + loan + ", this will be for the fall semester, meaning you will have about $" + String.format("%.2f", monthlyLoan) + " for each month");
        double extraMoney = monthlyLoan - mandatoryMonthlyCharges;
        System.out.println("This also means that you will have an extra $" + String.format("%.2f", extraMoney) + " a month");
    }
}
