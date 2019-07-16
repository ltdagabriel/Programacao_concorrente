package A08_executor.part2_ex_03;

import java.util.*;
import java.util.concurrent.*;

/**
 * Faça um programa concorrente para multiplicar duas matrizes.
 *
 * @author Gabriel Choptian
 */

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        int[][] A = new int[][]{{2, 3}, {1, 1}, {1, 1}};
        int[][] B = new int[][]{{2, 1, 1}, {3, 1, 1}};

        Set<Callable<Pos>> callables = new HashSet<>();
        int[][] C = new int[A.length][B[0].length];

        for (int k = 0; k < A.length; k++) {
            for (int j = 0; j < A.length; j++) {
                List<Integer> a = new ArrayList<>();
                List<Integer> b = new ArrayList<>();

                for (int i = 0; i < B.length; i++) {
                    a.add(A[k][i]);
                    b.add(B[i][j]);
                }
                int finalK = k;
                int finalJ = j;
                callables.add(() -> {
                    int res = 0;
                    for (int i = 0; i < a.size(); i++) {
                        res += a.get(i) * b.get(i);
                    }
                    Pos pos = new Pos(res, finalK, finalJ);
                    return pos;
                });

            }
        }


        try {
            List<Future<Pos>> futures = executor.invokeAll(callables);
            int k = 0;
            for (Future<Pos> future : futures) {
                Pos value = future.get();
                C[value.x][value.y] = value.value;

                k++;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Matriz A");
        for (int[] a : A) print(a);
        System.out.println("Matriz B");
        for (int[] a : B) print(a);
        System.out.println("Matriz AxB");
        for (int[] a : C) print(a);


    }

    public static void print(int[] row) {
        for (int i : row) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

class Pos {
    int value;
    int x;
    int y;

    Pos(int value, int x, int y) {

        this.value = value;
        this.x = x;
        this.y = y;
    }
}