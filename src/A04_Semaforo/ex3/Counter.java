package A04_Semaforo.ex3;

public class Counter {
    private int i = 0;

    synchronized void increment() {
        i++;
    }

    synchronized int getI() {
        return i;
    }
}
