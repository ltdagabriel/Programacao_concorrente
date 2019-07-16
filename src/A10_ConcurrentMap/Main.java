package A10_ConcurrentMap;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Fa¸ca um programa usando Threads e ConcurrentMap para
 * calcular a frequˆencia de cada letra em um texto
 */
public class Main {

    public static void main(String[] args) {
        CharCount count = new CharCount();

        String texto = "1223334444abbccc";
        Set<Future> futures = new HashSet<>();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (char c : texto.toCharArray()) {
            // funcao lambda para contar letras
            Future future = executor.submit(() -> {
                count.add(c);
            });

            futures.add(future);
        }
        for (Future future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        count.print();
    }
}

class CharCount {
    ConcurrentMap<Character, AtomicLong> freqs = new ConcurrentHashMap<>();

    public void add(char c) {
        AtomicLong a = freqs.get(c);
        // Cria instancia no map se não existe
        if (a == null) {
            a = new AtomicLong(1);
            a = freqs.putIfAbsent(c, a);
        }
        // Incrementa a variavel
        if (a != null) {
            a.incrementAndGet();
        }
    }

    public void print() {
        System.out.println("Letra: Numero de repetições");

        freqs.forEach((c, count) -> System.out.printf("\t%s: %s%n", c, count));
    }
}
