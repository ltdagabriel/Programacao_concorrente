package A09_ColecoesConcorrentes.ex_01_ArrayBlockingQueue;

import java.util.concurrent.*;

/**
 * Implemente duas versões do problema do produtor/consumidor com M
 * produtores e N consumidores usando ArrayBlockingQueue e
 * LinkedBlockingQueue. Compare o desempenho das duas
 * implementações.
 *
 * @author Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        ExecutorService executorService = Executors.newCachedThreadPool();
        int m = 3;
        int n = 4;
        for (int i = 0; i < m; i++) {
            executorService.execute(new Produtor(queue));
        }
        for (int i = 0; i < n; i++) {
            executorService.execute(new Consumidor(queue));
        }
    }
}
