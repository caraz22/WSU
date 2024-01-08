package ProjectThree;

public class ExpressCheckout extends CheckoutLane {
    
    public ExpressCheckout() {
        super();
    }

    public double getCheckoutTime(Customer c) {
        double checkoutTime = (0.10 * c.getNumItems()) + 1.0;
        return checkoutTime;
    }
}
