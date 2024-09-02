package multithreading.concurrentCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronisedCollection {
    public static void main(String[] args) throws InterruptedException {
        // List<Integer> list = new ArrayList<>();                           // give different result every running
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread one = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        one.start();
        two.start();

        // ensure that the Threads a being completed
        one.join();
        two.join();

        System.out.println(list.size());
    }
}
