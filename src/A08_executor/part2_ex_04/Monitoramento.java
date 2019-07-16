package A08_executor.part2_ex_04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

public class Monitoramento implements Runnable {

    Path path;
    WatchService path_monitor;
    BufferedWriter bw;


    Monitoramento(String path) throws IOException {
        this.path = Paths.get(path);
        path_monitor = this.path.getFileSystem().newWatchService();
        this.path.register(path_monitor,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        FileWriter file = new FileWriter(new File("log.txt"));
        bw = new BufferedWriter(file);
    }

    @Override
    public void run() {
        while (true) {
            try {
                WatchKey key = path_monitor.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    try {
                        bw.write(String.format("%s ::: ", event.context().toString()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                try {
                    bw.newLine();
                    bw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                key.reset();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
