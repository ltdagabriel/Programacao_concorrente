package lista2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exercicio_5 {
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

class Leitura extends Thread{
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