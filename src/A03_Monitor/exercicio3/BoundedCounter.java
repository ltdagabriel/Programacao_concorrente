package A03_Monitor.exercicio3;

import java.util.concurrent.Semaphore;

public class BoundedCounter {
    private int i;
    private int min;
    private int max;
    private Semaphore mutex = new Semaphore(1);

    BoundedCounter(int min, int max) {
        i = min + 3;
        this.max = max;
        this.min = min;
    }

    void increment() throws InterruptedException {
        mutex.acquire();
        i++;
        int finali = i;
        mutex.release();

        if (finali > max) {
            try {
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("i: " + finali);
    }

    void decrement() throws InterruptedException {
        mutex.acquire();
        i--;
        int finali = i;
        mutex.release();

        if (finali < min) {
            try {
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("i: " + finali);

    }
}
