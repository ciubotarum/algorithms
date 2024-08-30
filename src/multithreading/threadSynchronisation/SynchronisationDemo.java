package multithreading.threadSynchronisation;

public class SynchronisationDemo {
    private static int counter1 = 0;
    private static int counter2 = 0;
    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
//                counter++;
                increment1();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
//                counter++;
                increment2();
            }
        });

        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value : " + counter1 + " -- " + counter2);


        // We get different resul every running
        // It's a non-atomic operation

        // 1. Load
        // 2. Increment
        // 3. Set back the value
        // counter = 0;  incrementValue = 1;  Thread 1
        // counter = 0;  incrementValue = 1;  Thread 2
        // We should have incrementValue = 2 in the Thread 2 but still is 1
        // This names as inconsistency

        // To avoid this
        // counter = 0;  incrementValue = 1; Setting back the value to the counter = 1; Thread 1
        // add the keyword synchronized to the method increment to avoid two threads to access the same variable at the
        // same time
    }

    private synchronized static void increment1() {
        counter1++;
    }
    private synchronized static void increment2() {
        counter2++;
    }
}
