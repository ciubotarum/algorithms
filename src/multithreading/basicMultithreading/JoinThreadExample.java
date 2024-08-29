package multithreading.basicMultithreading;

public class JoinThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1 : " + i);
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                System.out.println("Thread 2 : " + i);
            }
        });

        System.out.println("Before executing the threads");

        one.start();
        two.start();
        one.join();                                          // When the one is finished executing the sout function will be printed
        two.join();                                          // The sout function will be executed after both threads will finish
        System.out.println("Done executing the threads!");   // this will be the first printed
    }
}
