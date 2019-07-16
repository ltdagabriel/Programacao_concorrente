package A08_executor.part1_ex_01;

public class Main {
    public static void main(String[] args) {
        Ret value = new Ret();
        int numero = 5;
        Thread t = new Thread(new Fatorial(numero, value));

        try {
            t.start();
            t.join();

            System.out.printf("Fatorial de %d é %d%n", numero, value.value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

