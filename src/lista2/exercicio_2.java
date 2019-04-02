package lista2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class exercicio_2 extends Thread {
    public static void main(String[] args) {
        exercicio_2 th = new exercicio_2();
        th.start();
    }

    @Override
    public void run() {
        try {
//            Caminho inteiro, não funcionou com caminho relativo
            Path file = Paths.get("/home/ltdagabriel/IdeaProjects/Programacao_concorrente/src/lista2/frases.txt");
            List<String> lines = Files.readAllLines(file);
            for (String i:lines){
                System.out.println(i);
                sleep(10000);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
