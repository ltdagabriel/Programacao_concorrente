package A02_Thread_Slide28.exercicio2;

/**
 * Fa¸ca um programa em Java para testar um conjunto de
 * opera¸c˜oes sobre um grupo de extras.threads. Use o ThreadGroup
 *
 * @autor: Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("First Thread Group");
        new Thread(group, () -> System.out.println("Ola Mundo!")).start();
        new Thread(group, () -> System.out.println("Ola Mundo!")).start();
        new Thread(group, () -> System.out.println("Ola Mundo!")).start();

        System.out.println(group.activeCount());
        System.out.println(group.activeGroupCount());
        group.interrupt();
    }
}
