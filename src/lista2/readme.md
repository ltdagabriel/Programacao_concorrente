###1. Faça um programa em Java que inicie três threads e, cada thread, espere um tempo aleatório para terminar.
```java
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
```
###2. Faça uma thread Java que realize a leitura de um arquivo texto com frases e exiba as frases a cada 10 segundos.
```java

public class exercicio_2 extends Thread {
    public static void main(String[] args) {
        exercicio_2 th = new exercicio_2();
        th.start();
    }

    @Override
    public void run() {
        try {
//            Caminho inteiro, nã funcionou com caminho relativo
            Path file = Paths.get("/home/ltdagabriel/IdeaProjects/Programacao_concorrente/src/lista2/frases.txt");
            List<String> lines = Files.readAllLines(file);
            System.out.println(lines.size());
            for (String i:lines){
                System.out.println(i);
                sleep(10000);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
###3. Faça um programa Java que envia interrupções para as threads dos exercícios anteriores. As threads devem fazer o tratamento dessas interrupções e realizar uma finalização limpa.

###4. Faça uma Thread que monitora um conjunto de threads e exiba quais threads receberam sinais de interrupção.
###5. Faça uma thread Java que fica aguardando uma sequência numérica de tamanho arbitrário digitado por usuário para realizar uma soma. Use o join().