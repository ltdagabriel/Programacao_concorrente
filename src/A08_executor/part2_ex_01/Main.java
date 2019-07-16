package A08_executor.part2_ex_01;

import java.util.*;
import java.util.concurrent.*;

/**
 * Faça um programa que localize o devolve_maior valor em um vetor. Divida o
 * programa em tarefas que localizam o devolve_maior valor em um segmento do
 * vetor. O programa deve possibilitar especificar o número de tarefas e o
 * número de threads para resolver o problema.
 *
 * @author Gabriel Choptian
 */
public class Main {
    private static int devolve_maior(List<Integer> numbers) {
        System.out.println(numbers.toString());
        numbers.sort(Collections.reverseOrder());
        return numbers.get(0);
    }

    public static void main(String[] args) {
        int numero_tarefas = 2;
        int numero_thread = 2;
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 6, 3,2, 4, 51, 6));

        ExecutorService executor = Executors.newFixedThreadPool(numero_thread);

        Set<Callable<Integer>> callables = new HashSet<>();

        int size = (int) Math.ceil(numeros.size() / (float) numero_tarefas);

        for (int i = 0; i < numeros.size(); i+=size) {
            int start = i;
            int end = Math.min(start + size, numeros.size());
            callables.add(() -> devolve_maior(numeros.subList(start, end)));
        }

        try {
            List<Integer> numeros_novo = new ArrayList<>();

            List<Future<Integer>> futures = executor.invokeAll(callables);
            for (Future<Integer> i : futures) {
                numeros_novo.add(i.get());
            }
            System.out.printf("Maior é %d%n", devolve_maior(numeros_novo));

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}

