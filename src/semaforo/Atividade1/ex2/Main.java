package semaforo.Atividade1.ex2;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore sem1 = new Semaphore(0);
        Semaphore sem2 = new Semaphore(0);

        new T1(sem1,sem2).start();
        new T2(sem1,sem2).start();

    }
}

