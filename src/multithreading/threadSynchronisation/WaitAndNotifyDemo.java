package multithreading.threadSynchronisation;

public class WaitAndNotifyDemo {
    private static final Object LOCK = new Object();
    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread two = new Thread(() -> {
            try {
                two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        one.start();
        two.start();
    }

    // Wait is used for inter Thread communication and synchronization while
    // sleep is used for pausing the execution of the thread for a specifying duration

    private static void one() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("Hello from method one ...");
            LOCK.wait();
            System.out.println("Back again in the method one");
        }
    }

    private static void two() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("Hello from method two ...");
            LOCK.notify();
            System.out.println("Back from method two even after notifying ...");
        }
    }
}
