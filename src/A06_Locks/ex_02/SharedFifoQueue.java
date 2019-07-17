package A06_Locks.ex_02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedFifoQueue {
    Lock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();
    int max;
    List<Integer> list = new ArrayList<>();

    public SharedFifoQueue(int max) {
        this.max = max;
    }

    void add(int value) throws InterruptedException {
        lock.lock();
        while (list.size() >= max) {
            full.await();
        }
        list.add(value);
        empty.signal();
        lock.unlock();
    }

    int remove() throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == 0) {
                empty.await();
            }
            return list.remove(0);
        } finally {
            full.signal();
            lock.unlock();
        }
    }


}
