package A09_ColecoesConcorrentes.ex_01_LinkedBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable{
    private final BlockingQueue<String> queue;

    public Consumidor(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println(queue.take());
                Thread.sleep(1_000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
