package semaforo.Atividade1.ex2;

import java.util.concurrent.Semaphore;

class T2 extends Thread {
    private final Semaphore sem1;
    private final Semaphore sem2;

    T2(Semaphore sem1, Semaphore sem2) {
        this.sem1 = sem1;
        this.sem2 = sem2;
    }

    @Override
    public void run() {
        // Trecho 2.1
        try {
            System.out.println("<trecho 2.1>");
            sleep(Math.round(Math.random() * 10000));
            sem1.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Trecho 2.2
        try {
            sem2.acquire();
            System.out.println("<trecho 2.2>");
            sleep(Math.round(Math.random() * 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
