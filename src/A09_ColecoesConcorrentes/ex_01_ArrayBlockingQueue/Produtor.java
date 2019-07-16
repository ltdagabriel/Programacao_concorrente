package A09_ColecoesConcorrentes.ex_01_ArrayBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Produtor implements Runnable {
    private final BlockingQueue<String> queue;

    public Produtor(BlockingQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            while (true) {
                queue.put("Tarefa " + new Random().nextInt(100));
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
