package lista2;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class exercico_4 extends Thread {

    public static void main(String[] args) {
        List<tread_aux> lista = new ArrayList<>();
        for(int i=0; i<5;i++){
            tread_aux a = new tread_aux();
            a.setName(String.format("Thread a_%d",i));
            lista.add(a);
        }
        Controle controle = new Controle(lista);
        for(tread_aux i:lista){
            i.start();
            i.interrupt();
        }
        controle.start();
        controle.interrupt();
    }
}

class Controle extends Thread {
    private List<tread_aux> threads;

    Controle(List<tread_aux> list) {
        threads = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int ok=0;
                for (tread_aux i : threads) {
                    if (i.isInterrupted()) {
                        System.out.println(String.format("Thread [%s]Interrompida", i.getName()));
                        ok = 1;
                    }
                }
                sleep(10);
                if(ok ==1) break;
            }
        } catch (InterruptedException | ConcurrentModificationException e) {
            System.out.println("Thread Controle interrompida");
        }

        System.out.println("Todas as Threads foram finalizadas!");
    }

}
class tread_aux extends Thread {

    @Override
    public void run() {
        while(true) {

        }
    }
}