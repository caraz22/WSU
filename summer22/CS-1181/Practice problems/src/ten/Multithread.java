package ten;

public class Multithread extends Thread {

    private int maxDivisors = 0;
    private int answer = 0;
    private int n;

    public Multithread(int n) {
        this.n = n;
    }

    public int getMaxDivisors() {
        return maxDivisors;
    }

    public int getAnswer() {
        return answer;
    }

    public void setMaxDivisors(int maxDivisors) {
        this.maxDivisors = maxDivisors;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int n() {
        return n;
    }

    public void getN(int n) {
        this.n = n;
    }
    
    @Override
    public void run() {
        for (int i = n - 499; i <= n; i ++) {
            getNumDivisors(i);
        }
    }

    public void getNumDivisors(int n) {
		int numDivisors = 0;
		for (int i=1; i<=n; i++) {
			if (n % i == 0) {
				numDivisors++;
			}
		}

        if (numDivisors > this.maxDivisors) {
            setMaxDivisors(numDivisors);
            setAnswer(n);
		}
	}
}
