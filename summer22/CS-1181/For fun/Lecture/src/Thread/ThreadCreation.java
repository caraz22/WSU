package Thread;

public class ThreadCreation extends Thread {
    
    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadCreation t = new ThreadCreation();

        t.setName("First approach: a new thread is created.");
        t.start();

        //t.run();

        //main()
        t.join();

        System.out.println("Thread main(): " + Thread.currentThread().getName());
    }
}
