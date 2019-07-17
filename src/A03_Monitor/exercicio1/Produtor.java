package A03_Monitor.exercicio1;

public class Produtor extends Thread {
    private Monitor monitor;

    Produtor(Monitor monitor){
        this.monitor = monitor;
    }

    @Override
    public void run() {
        monitor.produzir("Produto produzido... '-'");
    }
}
