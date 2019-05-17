package threads.lista1.exercicio1;

/**
 * Implemente o exemplo anterior usando Lambda Expression
 *
 * @autor: Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Hello from a Thread!");
        }).start();
    }
}
