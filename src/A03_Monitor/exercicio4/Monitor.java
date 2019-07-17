package A03_Monitor.exercicio4;

public class Monitor {
    private boolean empty;

    Monitor(boolean empty) {
        this.empty = empty;
    }

    synchronized void take() throws InterruptedException {
        while (empty) {
            wait();
        }
        empty = true;
        notifyAll();
    }

    synchronized void put() throws InterruptedException {
        while (!empty) {
            wait();
        }
        empty = false;
        notifyAll();
    }

}
