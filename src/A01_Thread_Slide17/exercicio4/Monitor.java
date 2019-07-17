package A01_Thread_Slide17.exercicio4;


import java.util.ConcurrentModificationException;
import java.util.List;

class Monitor extends Thread {
    private List<Thread> threads;

    Monitor(List<Thread> list) {
        threads = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int ok=0;
                for (Thread i : threads) {
                    if (i.isInterrupted()) {
                        System.out.println(String.format("Thread [%s]Interrompida", i.getName()));
                        ok = 1;
                    }
                }
                sleep(10);
                if(ok ==1) break;
            }
        } catch (InterruptedException | ConcurrentModificationException e) {
            System.out.println("Thread Controle interrompida");
        }

        System.out.println("Todas as Threads foram finalizadas!");
    }

}
