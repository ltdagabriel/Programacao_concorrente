package A01_Thread_Slide17.exercicio2;


/**
 * Faça uma thread Java que realize a leitura de um arquivo
 * texto com frases e exiba as frases a cada 10 segundos.
 *
 * @autor: Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        new Thread_file().start();
    }
}
