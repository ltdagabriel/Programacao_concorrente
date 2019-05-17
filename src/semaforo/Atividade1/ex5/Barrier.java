package semaforo.Atividade1.ex5;

import java.util.concurrent.Semaphore;

public class Barrier {
    private Semaphore lock = new Semaphore(1);
    private Semaphore barrier = new Semaphore(0);
    private int n;
    private int i= 0;

    Barrier(int n) {
        this.n = n;
    }

    public void acquire() throws InterruptedException {
        lock.acquire();
        i++;

        lock.release();
        if(i< n)
            barrier.acquire();
        else
            barrier.release();
    }

    public void release() throws InterruptedException {
        barrier.release();
    }

}
