package A05_Filosofo.deadlock;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        Semaphore[] forks = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            forks[i] = new Semaphore(1);
        }


        for (int i = 0; i < n; i++) {
            new Thread(new Filosofo(forks, i)).start();
        }

    }
}

