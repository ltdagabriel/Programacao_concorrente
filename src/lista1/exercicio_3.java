package lista1;

import java.util.concurrent.TimeUnit;

public class exercicio_3 {
    public static void main(String[] args) throws InterruptedException {
        Contador temp = new Contador();
        int n = 20000;
        for (int i = 0; i < n; i++) {
            Implement_threads a = new Implement_threads(temp);
            a.start();
        }
        TimeUnit.SECONDS.sleep(1);
        if (temp.getNumber() != n) {
            System.out.println("Falha de seguranção contador menor que o numero de threads!");
            System.out.println("Numero de Threads encontrada " + temp.getNumber() + " de " + n + " criadas");
        }
    }
}
