package multithreading.basicMultithreading;

public class ThreadPriorityExample {
    public static void main(String[] args) {
        // First example to demonstrate the priority
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
//        System.out.println(Thread.currentThread().getPriority());

        // Second example FIFO
        System.out.println(Thread.currentThread().getName() + " says Hi!");

        Thread one = new Thread(() -> {
            System.out.println("Thread one says Hi as well!");
        });

        one.setPriority(Thread.MAX_PRIORITY);
        one.start();
    }
}

