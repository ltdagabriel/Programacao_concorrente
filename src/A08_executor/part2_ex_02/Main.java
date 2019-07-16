package A08_executor.part2_ex_02;

import java.util.*;
import java.util.concurrent.*;

/**
 * Faça um programa que calcule a soma dos elementos de uma matriz
 * MxN. Divida o programa em tarefas que somam as linhas. O programa
 * deve possibilitar especificar o número de threads para resolver o problema.
 *
 * @author Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        int arr[][] = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};

        int numero_thread = 2;

        ExecutorService executor = Executors.newFixedThreadPool(numero_thread);

        Set<Callable<Integer>> callables = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int finalI = i;
            callables.add(()-> Arrays.stream(arr[finalI]).sum());
        }

        try {
            int soma = 0;
            List<Future<Integer>> futures = executor.invokeAll(callables);
            for (Future<Integer> i : futures) {
                soma += i.get();
            }
            System.out.printf("Soma: %d%n", soma);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

    }
}
