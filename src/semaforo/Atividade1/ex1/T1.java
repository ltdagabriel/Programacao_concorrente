package ex1;

import java.util.concurrent.Semaphore;

class T1 extends Thread {
    private final Semaphore semaphore;

    T1(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            System.out.println("Iniciando T1");
            sleep(Math.round(Math.random() * 10000));
            semaphore.release();
            System.out.println("T1 finalizado");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
