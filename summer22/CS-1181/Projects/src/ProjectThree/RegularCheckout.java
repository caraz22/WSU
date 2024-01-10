package ProjectThree;

class RegularCheckout extends CheckoutLane {

    public RegularCheckout() {
        super();
    }

    public double getCheckoutTime(Customer c) {
        double checkoutTime = (0.05 * c.getNumItems()) + 2.0;
        return checkoutTime;
    }
}
