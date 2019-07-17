package A04_Semaforo.ex4;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        int n = 5;
        Semaphore semaphore = new Semaphore(n);

        for(int i=0;i<100;i++)
            new T1(semaphore).start();

    }
}

