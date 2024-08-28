package multithreading.sequential;

public class SequentialExecutionDemo {
    public static void main(String[] args) {
        // Single thread
        // Every line is executed one by one
        demo1();        // is executed first
        demo2();        // is executed after the first one is executed
    }

    private static void demo1() {
        for (int i = 0; i < 5; i++) {
            System.out.println("From demo 1 " + i);
        }
    }
    private static void demo2() {
        for (int i = 0; i < 5; i++) {
            System.out.println("From demo 2 " + i);
        }
    }


}
