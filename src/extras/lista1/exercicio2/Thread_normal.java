package extras.lista1.exercicio2;

public class Thread_normal extends Thread {
    @Override
    public void run() {
        try {
            sleep(10);
            System.out.printf("Thread by %s%n", this.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
