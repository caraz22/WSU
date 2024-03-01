package Thread;

public class WaitNotifyExample {
    
    public static void main(String[] args) {

        Order order = new Order("French fries");

        Thread waiterThread = new Thread(new Waiter(order));
        Thread cookThread = new Thread(new Cook(order));

        waiterThread.start();
        cookThread.start();
    }
}

class Cook implements Runnable {

    Order order;

    public Cook(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        System.out.println("The cook has received the order.");
        order.cookFood();
    }
}

class Waiter implements Runnable {

    Order order;

    public Waiter(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        order.deliverFood();
        System.out.println("The waiter has delivered the order.");
    }
}

class Order {
    
    String order;
    boolean isReady;

    public Order(String order) {
        this.order = order;
    }

    public synchronized void deliverFood() {
        while (!isReady) {
            System.out.println("Waiting to deliver the food ...");
            try {
                this.wait(); //lock is auto released
            } catch (InterruptedException ie) {
                
            }
        }
    }

    public synchronized void cookFood() {
        System.out.println("Cooking the food ...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {

        }

        System.out.println("The food is ready!");
        isReady = true;
        this.notifyAll(); //release lock
    }
}