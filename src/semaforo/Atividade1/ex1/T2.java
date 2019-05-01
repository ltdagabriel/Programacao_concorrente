package semaforo.Atividade1.ex1;

import java.util.concurrent.Semaphore;

class T2 extends Thread {
    private final Semaphore semaphore;

    T2(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Esperando evento de t1...");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Continuando!!");
    }
}
