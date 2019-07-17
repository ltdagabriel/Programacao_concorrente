package A03_Monitor.exercicio4;

import static java.lang.Thread.sleep;

/**
 * A barbearia tem:
 * um barbeiro
 * uma cadeira de barbeiro
 * algumas cadeiras para os fregueses esperarem
 * <p>
 * Se o movimento estiver fraco (nenhum freguês), o barbeiro senta na sua cadeira e dorme;
 * Quando um freguês chega no salão vazio, ele tem que acordar o barbeiro;
 * <p>
 * Se outros fregueses chegam enquanto o barbeiro está ocupado, eles:
 * Sentam na cadeira de espera
 * Vão embora, se não houver cadeira vazia.
 */
public class Barbearia {
    private Monitor customers = new Monitor(true);
    private Monitor barbers = new Monitor(true);
    private Monitor mutex = new Monitor(false);
    private int waiting = 0;
    private int chairs;
    private boolean close = false;

    Barbearia(int chairs) {
        this.chairs = chairs;
    }
    public void setClose(){
        close = true;
    }

    public void cortar_cabelo() throws InterruptedException {
        while (!close) {
            customers.take();
            mutex.take();
            waiting--;
            barbers.put();
            mutex.put();

            System.out.println("[Barbeiro] Cortando cabelo do cliente...");
            sleep(3_000);
            System.out.println("[Barbeiro] Cabelo cortado...");
        }
    }

    public void mudar_corte() throws InterruptedException {
        mutex.take();
        sleep(1_000);
        if (waiting < chairs) {
            waiting++;
            customers.put();
            mutex.put();
            barbers.take();
            System.out.println("[Cliente] Aguardando corte");
        } else {
            System.out.println("[Cliente] Não ha espaço, saindo!");
            mutex.put();
        }

    }

}