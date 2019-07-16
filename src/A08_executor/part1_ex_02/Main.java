package A08_executor.part1_ex_02;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int n = 5;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Fatorial fat = new Fatorial(5);

        Future<Integer> future = executor.submit(fat);

        try {
            System.out.println("Fatorial de " + n + " é " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
