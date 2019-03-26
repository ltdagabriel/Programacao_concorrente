### 1. Implemente o exemplo anterior usando Lambda Expression.
```java
public class exercicio_1 {
    public static void main(String[] args){
        new Thread(() -> {
            System.out.println("Thread lamba Ex1!");
        }).start();
    }
}
```
### 2. Faça um programa que receba um valor indicando um número de threads a serem instanciadas e teste os dois modos de criar threads em Java.
* dica: use o Thread.sleep para pausar as threads por um
intervalo de tempo.
    
````java
import java.util.Scanner;

public class exercicio_2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        for (int i = 0; i < number; i++){
            Implement_threads a = new Implement_threads();
            a.start();
            Implement_runnable b = new Implement_runnable();
            new Thread(b).start();
        }
    }
}
````
### 3. Implemente o exemplo de código que gera a condição de disputa e tente gerar um teste para que ocorra um problema de segurança (safety).
```java
import java.util.concurrent.TimeUnit;

public class exercicio_3 {
    public static void main(String[] args) throws InterruptedException {
        Contador temp = new Contador();
        int n = 20000;
        for (int i = 0; i < n; i++) {
            Implement_threads a = new Implement_threads(temp);
            a.start();
        }
        TimeUnit.SECONDS.sleep(1);
        if (temp.getNumber() < n) {
            System.out.println("Falha de seguranção contador menor que o numero de threads!");
            System.out.println("Numero de Threads encontrada " + temp.getNumber() + " de " + n + " criadas");
        }
    }
}
```
### Classes usadas
```java
public class Implement_threads extends Thread {
    private Contador cnt;

    public Implement_threads(Contador cnt){
        this.cnt = cnt;
    }
    public Implement_threads(){
    }

    @Override
    public void run() {
        try {
            sleep(1);
            if(cnt == null){
                System.out.println("Thread Ex2");
            }
            else {
                System.out.println("Contador +1(" + cnt.plus() + ')');

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Implement_runnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable ex2");
    }
}

public class Contador {
    private int number;

    Contador() {
        number = 0;
    }

    int plus() {
        this.number += 1;
        return this.number;
    }

    int getNumber() {
        return number;
    }
}
```