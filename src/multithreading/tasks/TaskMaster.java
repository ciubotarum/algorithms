package multithreading.tasks;

import java.util.Collection;
import java.util.concurrent.*;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskMaster {
//    While writing some code, you ran into a problem. Your code runs very slowly, because you need to run many functions.
//
//    You do a bit of troubleshooting and notice that you are not draining your system's resources.
//
//    Write a function that, given a list of "slow" functions, will return the sum of the results without waiting for each function to complete individually.

    // Initial taskManager code
//         var sum = 0;
//        for(var function: functions){
//            try{
//                sum += function.call();
//            }
//            catch(Exception e){
//                e.printStackTrace();
//            }
//        }
//         return sum;

    static int taskMaster(Collection<Callable<Integer>> functions) {
        var sum = 0;

        // Create an ExecutorService to run the tasks concurrently
        ExecutorService executor = Executors.newFixedThreadPool(functions.size());

        try {
            // Submit all tasks and get a list of Future objects
            List<Future<Integer>> futures = executor.invokeAll(functions);

            // Iterate over each Future to get the result and sum them up
            for (Future<Integer> future : futures) {
                try {
                    sum += future.get(); // future.get() blocks until the task is complete
                } catch (Exception e) {
                    e.printStackTrace(); // Handle exceptions from tasks
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always shut down the ExecutorService to free up resources
            executor.shutdown();
        }

        return sum;
    }

    static class SolutionSampleTest{
        static final Random random = new Random();

        static Callable<Integer> getFunction(long millis, int result){
            return () -> {
                Thread.sleep(millis);
                return result;
            };
        }

        @Test
        @DisplayName("Basic test")
        void basic1() {
            int expected = 5;
            var functions = List.of(
                    getFunction(random.nextLong(1000, 2001), 3),
                    getFunction(random.nextLong(1000, 2001), 2)
            );
            int actual = TaskMaster.taskMaster(functions);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Big test with same results")
        void basic2() {
            var functions = new ArrayList<Callable<Integer>>();
            var function = getFunction(random.nextLong(1000, 2001), 3);
            for(int i=0; i < 10; i++)
                functions.add(function);
            int expected = 30;
            int actual = TaskMaster.taskMaster(List.copyOf(functions));
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Big test with different results")
        void basic3() {
            var functions = new ArrayList<Callable<Integer>>();
            var functionA = getFunction(random.nextLong(1000, 2001), 3);
            for(int i=0; i < 10; i++)
                functions.add(functionA);
            var functionB = getFunction(random.nextLong(1000, 2001), 2);
            for(int i=0; i < 10; i++)
                functions.add(functionB);
            int expected = 50;
            int actual = TaskMaster.taskMaster(List.copyOf(functions));
            assertEquals(expected, actual);
        }
    }
}
