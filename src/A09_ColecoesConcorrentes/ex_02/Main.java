package A09_ColecoesConcorrentes.ex_02;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Implemente o problema do produtor/consumidor para uma estrutura com
 * os seguintes campos: número, simbolo, naipe, que representa uma carta
 * de baralho. A implementa¸c˜ao deve possibilitar que ap´os 10 cartas
 * produzidas por dois produtores, outros dois consumidores pegar˜ao
 * somente as maiores cartas. Os produtores somente devem produzir mais
 * cartas ap´os os consumidores removerem 3 cartas cada um. As cartas
 * remanescentes podem continuar na estrutura. Use a ordena¸c˜ao do
 * baralho da menor para maior: A, 2, ..., 10, Q, J, K.
 *
 * @author Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue<Carta> queue= new LinkedBlockingQueue<>(20);

        ExecutorService executorService = Executors.newCachedThreadPool();
        int m = 10;
        int n = 4;
        for (int i = 0; i < m; i++) {
            executorService.execute(new Produtor(queue));
        }
        for (int i = 0; i < n; i++) {
            executorService.execute(new Consumidor(queue));
        }
    }
}
