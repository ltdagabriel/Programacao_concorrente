package extras.lista1.exercicio3;

/**
 * Implemente o exemplo de código que gera a condição de disputa e tente
 * gerar um teste para que ocorra um problema de segurança (safety).
 *
 * @autor: Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int n = 100;
        for(int i=1;i<= n;i++){
            Thread_not_safety a = new Thread_not_safety(counter);
            a.setName(String.valueOf(i));
            a.start();
        }
    }
}
