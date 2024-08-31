package multithreading.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
    public static void main(String[] args) {
        // create the single thread executor
        //  ExecutorService create and start the threads
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            // create 5 threads
            for (int i = 0; i < 5; i++) {
                service.execute(new Task(i));
            }
        }
    }
}

class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task withID " + taskId + " being executed by Thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
