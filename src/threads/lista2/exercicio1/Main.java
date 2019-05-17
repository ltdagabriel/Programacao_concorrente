package threads.lista2.exercicio1;

/**
 * Faça um programa em Java que inicie três threads e, cada
 * thread, espere um tempo aleatório para terminar.
 *
 * @autor: Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread_wait().start();
        }
    }
}
