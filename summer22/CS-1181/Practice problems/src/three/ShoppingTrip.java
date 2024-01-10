package three;

public class ShoppingTrip {

    public static void main(String[] args) {

        Product[] products = new Product[4];

        NecessaryProduct productOne = new NecessaryProduct("Milk", 3.22);
        NecessaryProduct productTwo = new NecessaryProduct("Eggs", 2.38);
        LuxuryProduct productThree = new LuxuryProduct("Chips", 4.79);
        LuxuryProduct productFour = new LuxuryProduct("Ice cream", 4.99);

        products[0] = productOne;
        products[1] = productTwo;
        products[2] = productThree;
        products[3] = productFour;

        double total = 0;
        for (Product p : products) {
            total += p.getTotalPrice();
        }

        System.out.println(productOne);
        System.out.println(productTwo);
        System.out.println(productThree);
        System.out.println(productFour);
        System.out.println();
        System.out.printf("The total cost is $" + "%.2f", total);
    }
}
