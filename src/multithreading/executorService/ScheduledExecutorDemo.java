package multithreading.executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);   // nr of threads is one
        // we schedule the threads to be executed
        // initial delay is after how much time the execution will start
        service.scheduleAtFixedRate(new ProbeTask(), 1000, 2000, TimeUnit.MILLISECONDS);

        // Without this condition the program will continue in a loop
        try {
            if (!service.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }

    }
}

class ProbeTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Probing end point for updates ...");
    }
}
