package A05_Leitor.ex_01_prioriza_escritor;

import java.util.concurrent.Semaphore;

public class ReaderWriter {
    private int numReaders = 0;
    private int numwriters = 0;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore wlock = new Semaphore(1);
    private Semaphore rlock = new Semaphore(1);

    void startRead() throws InterruptedException {
        rlock.acquire();
        mutex.acquire();

        if (numReaders == 0) wlock.acquire();
        numReaders++;

        mutex.release();

        rlock.release();
    }

    void endRead() throws InterruptedException {
        mutex.acquire();

        numReaders--;
        if (numReaders == 0) wlock.release();

        mutex.release();
    }

    void startWriter() throws InterruptedException {
        mutex.acquire();

        if (numwriters == 0) rlock.acquire();
        numwriters++;

        mutex.release();

        wlock.acquire();
    }

    void endWriter() throws InterruptedException {
        mutex.acquire();

        numwriters--;
        if (numwriters == 0) rlock.release();
        mutex.release();

        wlock.release();
    }
}

