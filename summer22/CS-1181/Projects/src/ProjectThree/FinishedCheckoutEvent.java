package ProjectThree;

class FinishedCheckoutEvent extends Event {

    public FinishedCheckoutEvent(Customer customer, double time) {
        super(customer, time);
    }
}
