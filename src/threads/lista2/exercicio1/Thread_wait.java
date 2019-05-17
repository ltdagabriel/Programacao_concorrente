package threads.lista2.exercicio1;

public class Thread_wait extends Thread{
    @Override
    public void run() {
        try {
            sleep((long) (Math.random() * 1_000));
            System.out.printf("Finish %s%n", this.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
