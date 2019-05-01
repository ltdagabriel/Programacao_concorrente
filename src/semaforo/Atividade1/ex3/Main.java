package semaforo.Atividade1.ex3;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Counter counter = new Counter();
        for(int i=0;i<100;i++)
            new T1(semaphore, counter).start();

    }
}

