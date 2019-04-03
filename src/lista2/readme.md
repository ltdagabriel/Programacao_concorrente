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
```java

public class exercicio_3_1 extends Thread {
    @Override
    public void run() {
        Random gerador = new Random();

        try {
            int i = gerador.nextInt(100);
            System.out.println(String.format("Waiting... %d", i));
            sleep(i);
        } catch (InterruptedException e) {
            System.out.println("Interrupção por meio do usuario");
        }
    }
    public static void main(String[] args){
        for(int i =0; i<3;i++){
            exercicio_1 th = new exercicio_1();
            th.start();
            th.interrupt();
        }
    }
}

public class exercicio_3_2 extends Thread {
    public static void main(String[] args) {
        exercicio_3_2 th = new exercicio_3_2();
        th.start();
        th.interrupt();
    }

    @Override
    public void run() {
        try {
//            Caminho inteiro, não funcionou com caminho relativo
            Path file = Paths.get("/home/ltdagabriel/IdeaProjects/Programacao_concorrente/src/lista2/frases.txt");
            List<String> lines = Files.readAllLines(file);
            for (String i:lines){
                System.out.println(i);
                sleep(10_000);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Interrupção da Thread por meio da função principal.");
        }
    }
}

```
###4. Faça uma Thread que monitora um conjunto de threads e exiba quais threads receberam sinais de interrupção.
```java

public class exercicio_4 extends Thread {

    public static void main(String[] args) {
        List<Thread> lista = new ArrayList<>();
        for(int i=0; i<5;i++){
            Thread a = new Thread(() -> {
                while (true){}
            });
            a.setName(String.format("Thread a_%d",i));
            lista.add(a);
        }
        Controle controle = new Controle(lista);
        for(Thread i:lista){
            i.start();
            i.interrupt();
        }
        controle.start();
        controle.interrupt();
    }
}

class Controle extends Thread {
    private List<Thread> threads;

    Controle(List<Thread> list) {
        threads = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int ok=0;
                for (Thread i : threads) {
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
```
###5. Faça uma thread Java que fica aguardando uma sequência numérica de tamanho arbitrário digitado por usuário para realizar uma soma. Use o join().
```java

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
```