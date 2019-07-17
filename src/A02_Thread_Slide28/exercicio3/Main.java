package A02_Thread_Slide28.exercicio3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean ehPrimo(int value) {
        for (int j = 2; j <= value; j++) {
            if (((value % j) == 0) && (j != value)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();

        Thread a1 = new Thread(() -> {
            for (int i = 1; i < 50000; i++) {
                if (ehPrimo(i)) {
                    a.add(i);
                }
            }
        });
        a1.start();

        List<Integer> b = new ArrayList<>();
        Thread a2 = new Thread(() -> {
            for (int i = 50000; i < 100000; i++) {
                if (ehPrimo(i)) {
                    b.add(i);
                }
            }
        });
        a2.start();
        try {
            a1.join();
            a2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Integer> c = a;
        c.addAll(b);

        System.out.println(c.toString());

    }
}

