package lista2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
