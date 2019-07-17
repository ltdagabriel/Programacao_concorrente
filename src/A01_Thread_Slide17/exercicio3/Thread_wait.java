package A01_Thread_Slide17.exercicio3;

public class Thread_wait extends Thread{
    @Override
    public void run() {
        try {
            sleep((long) (Math.random() * 1_000));
            System.out.printf("Finish %s%n", this.getName());
        } catch (InterruptedException e) {
            System.out.println("Interrompido by " + e.getMessage());
        }
    }
}
