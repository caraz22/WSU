package ProjectThree;

class Customer {

    // private int customerID;
    private int numItems;
    private double timePerItem;
	public double arrivalTime;
    private double finishedCheckoutTime;

    public Customer(double arrivalTime, int numItems, double timePerItem) {
        this.arrivalTime = arrivalTime;
        this.numItems = numItems;
        this.timePerItem = timePerItem;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public int getNumItems() {
        return numItems;
    }

    public double getTimePerItem() {
        return timePerItem;
    }

    public double getFinishedCheckoutTime() {
        return finishedCheckoutTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public void setTimePerItem(double timePerItem) {
        this.timePerItem = timePerItem;
    }

    public void setFinishedCheckoutTime(double finishedCheckoutTime) {
        this.finishedCheckoutTime = finishedCheckoutTime;
    }

    public double getFinishedShoppingTime() {
        double shoppingTime = arrivalTime + (numItems * timePerItem);
        return shoppingTime;
    }

    public double getWaitTime() {
        double waitTime = this.getFinishedShoppingTime() + this.getFinishedCheckoutTime();
        return waitTime;
    }
}