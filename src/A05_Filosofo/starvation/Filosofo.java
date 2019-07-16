package A05_Filosofo.starvation;

import java.util.concurrent.Semaphore;

class Filosofo implements Runnable {
    private Semaphore[] forks;
    private final int id;

    Filosofo(Semaphore[] forks, int id) {
        this.forks = forks;
        this.id = id;
    }

    private void eat() throws InterruptedException {
        forks[id].acquire();
        // Pega o primeiro garfo tenta pega o 2 se não conseguir devolve
        if (forks[(id + 1) % forks.length].tryAcquire()) {
            forks[(id + 1) % forks.length].acquire();
            System.out.printf("Filosofo %d está comendo%n", id);
            Thread.sleep(5_000);
            forks[id].release();
            forks[(id + 1) % forks.length].release();
        }
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