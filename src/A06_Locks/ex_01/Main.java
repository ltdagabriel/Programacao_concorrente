package A06_Locks.ex_01;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Fa¸ca um programa usando Lock para simular a atualiza¸c˜ao de
 * um contador que ´e acessado por m´ultiplas threads. O
 * contador pode diminuir e aumentar.
 */
public class Main {
    public static void main(String[] args) {
        Count count = new Count();


        new CountLock(count).start();
        new CountLock(count).start();
        new CountLock(count).start();
        new CountLock(count).start();
        new CountLock(count).start();
    }
}

class CountLock extends Thread {

    private Count count;

    CountLock(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        count.lock();
        if (new Random().nextInt(100) < 50) {
            count.add();
        } else {
            count.sub();
        }
        System.out.println(count.get());
        count.unlock();
    }
}

class Count {
    private int value = 0;
    private ReentrantLock lock = new ReentrantLock();

    public int get() {
        return value;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

    public void add() {
        this.value = value + 1;
    }

    public void sub() {
        this.value = value - 1;
    }
}
