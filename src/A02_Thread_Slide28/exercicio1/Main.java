package A02_Thread_Slide28.exercicio1;

public class Main {
    /**
     * Fa¸ca um programa em Java que consulte periodicamente o
     * estado de um conjunto de extras.threads.
     *
     * @autor: Gabriel Choptian
     */
    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(() -> {
                try {
                    System.out.println("Inicializando Thread");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        new Check(threads).start();
    }
}

