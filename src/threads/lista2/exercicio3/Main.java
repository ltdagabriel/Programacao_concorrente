package threads.lista2.exercicio3;

/**
 * Faça um programa Java que envia interrupções para as threads dos
 * exercícios anteriores. As threads devem fazer o tratamento dessas
 * interrupções e realizar uma finalização limpa.
 *
 * @autor: Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        Thread a =new Thread_file();
        Thread b =new Thread_wait();
        a.start();
        a.interrupt();

        b.start();
        b.interrupt();
    }
}
