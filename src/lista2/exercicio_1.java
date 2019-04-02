package lista2;

import java.util.Random;

public class exercicio_1 extends Thread {
    @Override
    public void run() {
        Random gerador = new Random();

        try {
            int i = gerador.nextInt(100);
            System.out.println(String.format("Waiting... %d", i));
            sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        for(int i =0; i<3;i++){
            exercicio_1 th = new exercicio_1();
            th.start();
        }
    }
}

