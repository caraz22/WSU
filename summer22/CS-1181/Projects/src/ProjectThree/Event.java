package ProjectThree;

class Event implements Comparable<Event> {
    
    private Customer customer;
    private double time;

    public Event (Customer customer, double time) {
        this.customer = customer;
        this.time = time;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTime() {
        return time;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int compareTo(Event t) {
        if (this.getTime() < t.getTime()) {
            return -1;
        } else if (this.getTime() > t.getTime()) {
            return 1;
        } else {
            return 0;
        }
    }
}

