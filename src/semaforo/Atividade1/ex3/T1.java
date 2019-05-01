package semaforo.Atividade1.ex3;

import java.util.concurrent.Semaphore;

class T1 extends Thread {
    private final Semaphore semaphore;
    private final Counter counter;

    T1(Semaphore semaphore, Counter counter) {
        this.semaphore = semaphore;
        this.counter = counter;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
            counter.increment();
            System.out.printf("Counter: %d%n", counter.getI());
            sleep(1);

            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
