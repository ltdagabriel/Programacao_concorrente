package monitor.exercicio3;

public class BoundedCounter {
    private int i;
    private int min;
    private int max;

    BoundedCounter(int min, int max) {
        i = min;
        this.max = max;
        this.min = min;
    }

    void increment() {
        if (i + 1 >= max) {
            try {
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            i++;
        }
    }

    void decrement() {
        if (i - 1 <= min) {
            try {
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            i--;
        }
    }
}
