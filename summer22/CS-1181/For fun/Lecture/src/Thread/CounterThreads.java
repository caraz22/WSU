package Thread;

public class CounterThreads {
    
    private static volatile Counter counter = new Counter();

    public static void main(String[] args) {
        // CounterThreads t1 = new CounterThreads();
        // CounterThreads t2 = new CounterThreads();

        // t1.start();
        // t2.start();

        // t1.join();
        // t2.join();

        System.out.println("Counter final value: " + counter.value());
    }

    public void run() {
        for (int i = 0; i < 3000; i++) {
            counter.increment();
        }

        for (int i = 0; i < 3000; i ++) {
            counter.decrement();
        }
    }

    private static class Counter {
        
        private int c;
        private Object o = new Object(); //same as using "this"

        public synchronized void increment() {
            synchronized (o) { //synchronized block
                c++; //critical section
            }
            System.out.println("other statement");
        }

        public synchronized void decrement() {
            synchronized (o) {
                c--; //section section
            }
        }

        public synchronized int value() {
            synchronized (o) {
                return c;
            }
        }
    }
}
