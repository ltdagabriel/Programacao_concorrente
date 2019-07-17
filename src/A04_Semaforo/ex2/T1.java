package A04_Semaforo.ex2;

import java.util.concurrent.Semaphore;

class T1 extends Thread {
    private final Semaphore sem1;
    private final Semaphore sem2;

    T1(Semaphore sem1, Semaphore sem2) {
        this.sem1 = sem1;
        this.sem2 = sem2;
    }

    @Override
    public void run() {
        // Trecho 1.1
        try {
            System.out.println("<trecho 1.1>");
            sleep(Math.round(Math.random() * 10000));
            sem2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Trecho 1.2
        try {
            sem1.acquire();
            System.out.println("<trecho 1.2>");
            sleep(Math.round(Math.random() * 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
