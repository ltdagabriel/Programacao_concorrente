package threads.lista2.exercicio3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Thread_file extends Thread {
    @Override
    public void run() {
        Path file = Paths.get("files/frases.txt");
        try {
            List<String> lines = Files.readAllLines(file);

            for (String i : lines) {
                System.out.println(i);
                sleep(10_000);

            }
        } catch (InterruptedException e) {
            System.out.println("Interrompido by " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
