package semaforo.Atividade1.ex5;

import java.util.concurrent.Semaphore;

/**
 * Após n threads sincronizarem em um ponto em comum, um trecho específico (ponto crítico) pode
 * ser executado por cada uma delas.
 * Faça um código que possibilite barrar N threads em um ponto específico de execução e, após todas
 * alcançarem o ponto, todas devem executar o trecho de código após esse ponto.
 */
public class Main {
    public static void main(String[] args) {
        Barrier barrier = new Barrier(5);
        for(int i=0;i<5;i++){
            int finalI = i;
            new Thread() {

                @Override
                public void run() {
                    try {
                        barrier.acquire();
                        sleep(Math.round(1000));
                        System.out.printf("[%d]-> %s Running%n", finalI, this.getName());
                        barrier.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }.start();
        }

    }
}
