package A01_Thread_Slide17.exercicio4;

import java.util.ArrayList;
import java.util.List;

/**
 * Faça uma Thread que monitora um conjunto de extras.threads e
 * exiba quais extras.threads receberam sinais de interrupção.
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
