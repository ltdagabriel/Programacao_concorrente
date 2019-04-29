package monitor.exercicio2;

public class MonitorCounter {
    int i = 0;

    synchronized void increment() {
        i++;
        notifyAll();
    }

    synchronized void sleepUntil(int x) {
        while (x < i) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        i = 0;
    }
}
