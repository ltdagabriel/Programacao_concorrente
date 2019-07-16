package A05_Filosofo.deadlock;

import java.util.concurrent.Semaphore;

class Filosofo implements Runnable {
    private Semaphore[] forks;
    private final int id;

    Filosofo(Semaphore[] forks, int id) {
        this.forks = forks;
        this.id = id;
    }

    private void eat() throws InterruptedException {
        // pega os 2 garfos depois dovolve os 2
        forks[id].acquire();
        forks[(id + 1) % forks.length].acquire();
        System.out.printf("Filosofo %d está comendo%n", id);
        Thread.sleep(5_000);
        forks[id].release();
        forks[(id + 1) % forks.length].release();
    }

    @Override
    public void run() {
        while (true) {
            System.out.printf("Filosofo %d está Pensando!%n", id);
            try {
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
