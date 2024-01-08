package ten;

import java.util.ArrayList;

public class ThreadingDivisors {
    
    public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		int answer = 0;
		int maxDivisors = 0;

		ArrayList<Multithread> threads = new ArrayList<>();

		for (int i = 500; i < 100000; i += 500) {
			Multithread multipleThreads = new Multithread(i);
			multipleThreads.start();
			multipleThreads.join();
			threads.add(multipleThreads);
		}

		for (Multithread thread : threads) {
			if (thread.getMaxDivisors() > maxDivisors) {
				maxDivisors = thread.getMaxDivisors();
				answer = thread.getAnswer();
			}
		}

		System.out.println(answer + " has the most divisors (" + maxDivisors + ")");

		long end = System.currentTimeMillis();
		System.out.println(end - start + " milliseconds");
	}
}
