package semaforo.Atividade1.ex4;

import java.util.concurrent.Semaphore;

class T1 extends Thread {
    private final Semaphore sem1;

    T1(Semaphore sem1) {
        this.sem1 = sem1;
    }

    @Override
    public void run() {
        // Trecho 1.1
        try {
            sem1.acquire();
            System.out.println("start");
            sleep(Math.round(Math.random() * 10000));
            System.out.println("stop");
            sem1.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
