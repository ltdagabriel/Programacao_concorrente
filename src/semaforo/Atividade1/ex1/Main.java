package ex1;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);

        new T1(semaphore).start();
        new T2(semaphore).start();

    }
}

