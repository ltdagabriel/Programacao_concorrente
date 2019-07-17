package extras.lista1.exercicio2;

public class Thread_runnable implements Runnable{
    @Override
    public void run() {
        System.out.printf("Thread by %s%n", this.getClass().getName());
    }
}
