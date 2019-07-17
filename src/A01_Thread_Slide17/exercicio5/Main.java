package A01_Thread_Slide17.exercicio5;

import java.util.ArrayList;
import java.util.List;

/**
 * Faça uma thread Java que fica aguardando uma sequência numérica de
 * tamanho arbitrário digitado por usuário para realizar uma soma. Use o join().
 *
 * @autor: Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> lista = new ArrayList<>();
        Leitura reader = new Leitura(lista);
        reader.start();
        reader.join();
        System.out.println(sum(lista));
    }

    private static int sum(List<Integer> lista) {
        int sum = 0;
        for(int i:lista){
            sum += i;
        }
        return sum;
    }
}
