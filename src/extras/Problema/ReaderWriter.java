package extras.Problema;

import java.util.concurrent.Semaphore;

public class ReaderWriter {
    private int numReaders = 0;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore wlock = new Semaphore(1);

    void startRead() throws InterruptedException {
        mutex.acquire();

        if (numReaders == 0) wlock.acquire();
        numReaders++;

        mutex.release();
    }

    void endRead() throws InterruptedException {
        mutex.acquire();

        numReaders--;
        if (numReaders == 0) wlock.release();

        mutex.release();
    }

    void startWriter() throws InterruptedException {
        wlock.acquire();
    }

    void endWriter() {
        wlock.release();
    }
}
