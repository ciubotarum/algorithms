package multithreading.executorService;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            // We can't use .execute() when using Callable, we use submit
//            executorService.execute(new ReturnValueTask());
            Future<Integer> result = executorService.submit(new ReturnValueTask());

            result.cancel(true);  // the thread will be interrupted

            boolean cancelled = result.isCancelled();  // we can check in the code if a thread is cancelled or not

            boolean done = result.isDone();           // the thread is finished without errors

            System.out.println(result.get(1, TimeUnit.SECONDS));   // put a timeout to run
            // ^__ since the timeout is 1 second and the task run in 5 seconds we will have an TimeoutException
            System.out.println("Main thread execution completed! ");
        }
    }
}

// If we want to return a value we use Callable interface instead of Runnable
class ReturnValueTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);    // introduce latency, the result shows up after 5 seconds
        return 12;
    }
}
