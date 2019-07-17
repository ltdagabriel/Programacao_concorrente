package A03_Monitor.exercicio4;

public class Barbeiro extends Thread {
    private Barbearia barbearia;
    Barbeiro(Barbearia barbearia){
        this.barbearia = barbearia;
    }

    @Override
    public void run() {
        try {
            barbearia.cortar_cabelo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
