package extras.lista1.exercicio3;

public class Thread_not_safety extends Thread {
    private Counter counter;

    Thread_not_safety(Counter c) {
        counter = c;
    }

    @Override
    public void run() {
        int value = counter.setValue();
        if (!String.valueOf(value).equals(this.getName())) {
            System.out.println("Falha de segurançã!");
        }
    }
}
