package monitor.exercicio1;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();

        for (int i = 0; i < 5; i++) {
            Consumidor c = new Consumidor(monitor);
            Produtor p = new Produtor(monitor);
            c.start();
            p.start();
        }
    }
}
