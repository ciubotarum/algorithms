package multithreading.basicMultithreading;

public class DaemonUserThreadDemo {
    public static void main(String[] args) {
        // background thread
        Thread bgThread = new Thread(new DaemonHelper());
        Thread usrThread = new Thread(new UserThreadHelper());
        bgThread.setDaemon(true);      // set bgThreat to be the Daemon thread

        bgThread.start();
        usrThread.start();

        // Even if the Daemon thread still can run it gets shut down by the JVM after the User threads are terminated
    }
}

class DaemonHelper implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (count < 500) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println("Daemon helper running ...");
        }
    }
}

class UserThreadHelper implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User thread done with execution ...");
    }
}

