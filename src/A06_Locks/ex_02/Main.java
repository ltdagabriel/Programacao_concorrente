package A06_Locks.ex_02;

import java.util.Random;

/**
 * Crie uma classe SharedFifoQueue e use Conditions para
 * controlar se a fila est´a vazia ou cheia. Teste usando extras.threads
 * produtoras e consumidoras
 */
public class Main {
    public static void main(String[] args) {
        SharedFifoQueue sharedFifoQueue = new SharedFifoQueue(2);
        // Produtor
        for (int i = 0; i < 14; i++) {
            new Thread(() -> {
                try {
                    int valor = new Random().nextInt(100);
                    System.out.printf("Adicionando valor %d%n", valor);
                    sharedFifoQueue.add(valor);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        // Consumidor
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    System.out.printf("Removido valor %d%n", sharedFifoQueue.remove());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
