package A08_executor.part2_ex_04;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            executor.submit(new Monitoramento("files"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
