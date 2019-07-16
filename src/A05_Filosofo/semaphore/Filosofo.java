package A05_Filosofo.semaphore;

import java.util.concurrent.Semaphore;

class Filosofo implements Runnable {
    private Semaphore[] forks;
    private final int id;
    private Semaphore lock;

    Filosofo(Semaphore[] forks, int id, Semaphore lock) {
        this.forks = forks;
        this.id = id;
        this.lock = lock;
    }

    private void eat() throws InterruptedException {

        // Pega os 2 garfos ou nenhum
        lock.acquire();
        forks[id].acquire();
        forks[(id + 1) % forks.length].acquire();
        lock.release();

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