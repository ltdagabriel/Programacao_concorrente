package monitor.exercicio4;

public class Main {
    public static void main(String[] args) {
        Barbearia barbearia = new Barbearia(1);
        Barbeiro barbeiro = new Barbeiro(barbearia);
        barbeiro.start();
        for (int i = 0; i < 10; i++) {
            new Cliente(barbearia).start();
        }
    }
}
