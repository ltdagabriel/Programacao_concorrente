package A03_Monitor.exercicio2;

public class MonitorCounter {
    private int i = 0;

    synchronized void increment() {
        i++;
        notifyAll();
    }

    synchronized void sleepUntil(int x) {
        while (i < x) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }
}
