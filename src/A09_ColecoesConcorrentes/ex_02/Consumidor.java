package A09_ColecoesConcorrentes.ex_02;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable{
    private final BlockingQueue<Carta> queue;

    public Consumidor(BlockingQueue<Carta> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true){
                List<Carta> list = new LinkedList<>();

                System.out.printf("Cartas pegas: %d%n", queue.drainTo(list, 3));
                for (Carta item: list) {
                    item.print();
                }
                Thread.sleep(1_000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
