package A09_ColecoesConcorrentes.ex_02;

import java.util.SplittableRandom;
import java.util.concurrent.BlockingQueue;

public class Produtor implements Runnable {
    private final BlockingQueue<Carta> queue;

    public Produtor(BlockingQueue<Carta> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            String[] simbolos = new String[]{"A", null, null, null, null, null, null, null, null, null, "J", "Q", "k",};
            String[] naipes = new String[]{"Ouro", "Copa", "Paus", "Espada"};
            while (true) {
                int numero = new SplittableRandom().nextInt(1, 14);
                int naipe = new SplittableRandom().nextInt(0, 4);

                queue.put(new Carta(numero, simbolos[numero], naipes[naipe]));
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
