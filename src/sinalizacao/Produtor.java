package sinalizacao;

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
