package semaforo.Atividade1.ex6;

import java.util.concurrent.Semaphore;

public class Barrier {
    private Semaphore lock = new Semaphore(1);
    private Semaphore barrier = new Semaphore(0);
    private int n;
    private int numThreads = 0;

    Barrier(int n) {
        this.n = n;
    }

    public void acquire() throws InterruptedException {
        lock.acquire();
        numThreads++;
        int finalI = numThreads;
        lock.release();

        if (finalI == n){
            lock.acquire();
            numThreads = 0;
            lock.release();
            barrier.release(n);
			
		}
        if (finalI <= n) {
            barrier.acquire();
        }
    }

}
