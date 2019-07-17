package A03_Monitor.exercicio2;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        MonitorCounter m = new MonitorCounter();

        // Aguarda 10 segundos
        Thread a = new Thread(() -> {
            m.sleepUntil(10);
            System.out.println("Wait unt 10s");
        });
        a.start();

        // Relógio
        Thread b = new Thread(() -> {
            while (true) {
                try {
                    m.increment();
                    sleep(1_000);
                } catch (InterruptedException e) {
                    System.out.println("Relógio finalizado!");
                }
            }
        });
        b.start();
        try {
            a.join();
            b.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
