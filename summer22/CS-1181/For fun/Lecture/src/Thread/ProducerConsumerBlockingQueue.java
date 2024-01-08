package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumerBlockingQueue {
    
    public static void main(String[] args) {

        BlockingQueue<Object> q = new ArrayBlockingQueue<>(5); //capacity of 5
        Producer p = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);

        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}

class Producer implements Runnable {

    private final BlockingQueue<Object> queue;
    private int count;

    Producer(BlockingQueue<Object> q) {
        queue = q;
        count = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
                count++;
                Stuff o = produce(count);
                System.out.println("Produce stuff (put in the queue): " + o.counter);
                queue.put(o);

                if (count >= 10) {
                    System.out.println("done producing");
                    return;
                }
            }
        } catch (InterruptedException e) {

        }
    }

    Stuff produce(int count) {
        Stuff o = new Stuff(count);
        return o;
    }
}

class Stuff {

    int counter;
    
    public Stuff(int counter) {
        this.counter = counter;
    }
}

class Consumer implements Runnable {
    
    private final BlockingQueue<Object> queue;

    Consumer(BlockingQueue<Object> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);
                consume(queue.take());
            }            
        } catch (InterruptedException e) {

        }
    }

    void consume(Object x) {
        Stuff o = (Stuff) x;
        System.out.println("Consume stuff " + o.counter + " by " + Thread.currentThread().getName());
    }
}