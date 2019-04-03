package lista2;

import java.util.Random;

public class exercicio_3_1 extends Thread {
    @Override
    public void run() {
        Random gerador = new Random();

        try {
            int i = gerador.nextInt(100);
            System.out.println(String.format("Waiting... %d", i));
            sleep(i);
        } catch (InterruptedException e) {
            System.out.println("Interrupção por meio do usuario");
        }
    }
    public static void main(String[] args){
        for(int i =0; i<3;i++){
            exercicio_1 th = new exercicio_1();
            th.start();
            th.interrupt();
        }
    }
}

