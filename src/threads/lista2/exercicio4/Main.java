package threads.lista2.exercicio4;

import java.util.ArrayList;
import java.util.List;

/**
 * Faça uma Thread que monitora um conjunto de threads e
 * exiba quais threads receberam sinais de interrupção.
 *
 * @autor: Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        List<Thread> lista = new ArrayList<>();
        for(int i=0; i<5;i++){
            Thread a = new Thread(() -> {
                while (true){}
            });
            a.setName(String.format("Thread a_%d",i));
            lista.add(a);
        }
        Monitor controle = new Monitor(lista);
        for(Thread i:lista){
            i.start();
            i.interrupt();
        }
        controle.start();
        controle.interrupt();
    }
}
