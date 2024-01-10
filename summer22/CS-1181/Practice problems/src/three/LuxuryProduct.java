package three;

public class LuxuryProduct extends Product {

    public LuxuryProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = getPrice() * 1.0575;
        return totalPrice;
    }
    
}
