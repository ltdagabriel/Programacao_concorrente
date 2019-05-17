package threads.lista1.exercicio2;

import java.util.Scanner;

/**
 * Faça um programa que receba um valor indicando um número de threads
 * a serem instanciadas e teste os dois modos de criar threads em Java.
 * dica: use o Thread.sleep para pausar as threads por um intervalo de tempo.
 *
 * @autor: Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        while (number > 0) {
            new Thread_normal().start();
            new Thread(new Thread_runnable()).start();

            number--;
        }
    }
}
