package Thread;

public class ThreadCreation2 implements Runnable {

    @Override
    public void run() {

        System.out.println("Thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadCreation2());
        t.setName("Second approach: a new thread is created.");
        t.start();

        //main() thread
        System.out.println("Thread: " + Thread.currentThread().getName());
    }
}

