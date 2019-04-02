package lista1;

public class exercicio_1 {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Thread lamba Ex1!");
        }).start();
    }
}
