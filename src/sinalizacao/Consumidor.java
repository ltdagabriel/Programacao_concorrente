package sinalizacao;

public class Consumidor extends Thread {
    private Monitor monitor;

    Consumidor(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {

        System.out.println(monitor.consumir());
    }

}
