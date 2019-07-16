package A05_Leitor.ex_01_sem_inanicao;

import java.util.concurrent.Semaphore;

public class ReaderWriter {
    private int numReaders = 0;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore wlock = new Semaphore(1);
    private Semaphore lock = new Semaphore(1);

    void startRead() throws InterruptedException {
        lock.acquire();
        mutex.acquire();

        if (numReaders == 0) wlock.acquire();
        numReaders++;

        mutex.release();

        lock.release();
    }

    void endRead() throws InterruptedException {
        mutex.acquire();

        numReaders--;
        if (numReaders == 0) wlock.release();

        mutex.release();
    }

    void startWriter() throws InterruptedException {
        lock.acquire();
        wlock.acquire();
    }

    void endWriter() throws InterruptedException {
        lock.release();
        wlock.release();
    }
}

