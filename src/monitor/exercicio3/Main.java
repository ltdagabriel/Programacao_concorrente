package monitor.exercicio3;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        BoundedCounter m = new BoundedCounter(1,10);
        new Thread(() ->{
            try {
                while (true){
                    m.increment();
                    sleep((long) (1_000 * Math.random()));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->{
            try {
                while (true){
                    m.decrement();
                    sleep((long) (1_000 * Math.random()));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
