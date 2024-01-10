package Thread;

import java.util.concurrent.TimeUnit;

public class ThreadSum1 extends Thread {

    private int n;
    private int sum;

    public ThreadSum1(int n) {
        this.n = n;
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Thread main(): " + Thread.currentThread().getName());

        long startTime = System.nanoTime();

        ThreadSum1 t1 = new ThreadSum1(100);
        t1.setName("Thraed1 sum from 1 to n");
        t1.start();

        ThreadSum1 t2 = new ThreadSum1(1000);
        t2.setName("Thread2 sum from 1 to n");
        t2.start();

        //main()
        t1.join();
        t2.join();

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime; //nano seconds
        long msTime = TimeUnit.NANOSECONDS.toMillis(timeElapsed);

        System.out.println("Time elapsed " + timeElapsed + " ns");
        System.out.println("Time elapsed " + msTime + " ms");

        System.out.println("sum: " + (t1.getSum() + t2.getSum()));
    }
    
    @Override
    public void run() {

        System.out.println("Thread: " + Thread.currentThread().getName());
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
    }

    public int getSum() {
        return sum;
    }
}
