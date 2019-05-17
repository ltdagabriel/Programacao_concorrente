package threads.lista2.exercicio5;

import java.util.List;
import java.util.Scanner;

public class Leitura extends Thread{
    private List<Integer> lista;
    @Override
    public void run() {
        Scanner read = new Scanner(System.in);
        System.out.println("Digite varios numeros:");
        String in = read.nextLine();
        for(String i:in.split(" ")){
            lista.add(Integer.valueOf(i));
        }
    }
    Leitura(List<Integer> lista){
        this.lista = lista;
    }
}
