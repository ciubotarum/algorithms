package multithreading.concurrentCollection;

import java.util.concurrent.CountDownLatch;

public class Restaurant {
    public static void main(String[] args) throws InterruptedException {
        int numberOfChefs = 3;
        CountDownLatch latch = new CountDownLatch(numberOfChefs);

        new Thread(new Chef("Chef A", "Pizza", latch)).start();
        new Thread(new Chef("Chef B", "Pasta", latch)).start();
        new Thread(new Chef("Chef C", "Salad", latch)).start();

        // ensure that the entire thread of execution is blocked till the time all the 3 threads are completed
        latch.await();

        System.out.println("All dishes are ready! Let's start serving customers!");
    }
}
// Chef have to cook some dishes but the manager want to serve only after all the chefs finished their dishes
// We use the Countdown Latch to coordinate all the chefs
class Chef implements Runnable {
    private  final String name;
    private final String dish;
    private CountDownLatch latch;

    public Chef(String name, String dish, CountDownLatch latch) {
        this.name = name;
        this.dish = dish;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is preparing " + dish);
            Thread.sleep(2000);
            System.out.println(name + " has finished preparing " + dish);
            latch.countDown();           // when the task is completed
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
