package lista1;

import java.util.Scanner;

public class exercicio_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        for (int i = 0; i < number; i++) {
            Implement_threads a = new Implement_threads();
            a.start();
            Implement_runnable b = new Implement_runnable();
            new Thread(b).start();
        }
    }
}
