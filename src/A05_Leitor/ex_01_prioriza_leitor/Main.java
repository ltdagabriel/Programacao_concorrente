package A05_Leitor.ex_01_prioriza_leitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        ReaderWriter rw = new ReaderWriter();

        // Escritor
        for (int i = 0; i < 1; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        int value = new Random().nextInt(100);
                        rw.startWriter();
                        if (value < 25) {
                            list.add(new Random().nextInt(100));
                        } else if (list.size() > 0) {
                            list.remove(0);
                        }
                        rw.endWriter();
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 2; i++) {
            //Leitor
            new Thread(() -> {
                while (true) {
                    try {
                        rw.startRead();
                        System.out.println(list.toString());
                        rw.endRead();
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }
}
