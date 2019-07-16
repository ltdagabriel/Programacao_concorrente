package A08_executor.part1_ex_02;

import java.util.concurrent.Callable;

public class Fatorial implements Callable<Integer> {
    private int numero;

    public Fatorial(int numero) {
        this.numero = numero;
    }

    @Override
    public Integer call() throws Exception {
        int value = 1;
        for (int i = 1; i <= numero; i++) {
            value *= i;
        }

        return value;
    }
}
