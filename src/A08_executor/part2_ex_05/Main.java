package A08_executor.part2_ex_05;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Calendar time_event = Calendar.getInstance();
        time_event.set(Calendar.HOUR, 4);
        time_event.set(Calendar.MINUTE, 32);

        new Agenda(time_event, new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        });
    }

}

class Agenda {

    Agenda(Calendar date, Runnable task) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        long seconds = (date.getTime().getTime() - new Date().getTime()) / 1000;
        System.out.println(seconds);
        ScheduledFuture future = executor.schedule(task, seconds, TimeUnit.SECONDS);

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
