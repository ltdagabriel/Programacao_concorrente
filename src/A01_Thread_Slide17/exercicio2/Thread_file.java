package A01_Thread_Slide17.exercicio2;

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
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
