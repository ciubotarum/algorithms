package greedy;

import java.util.Arrays;

public class LargestSum {
//    Find the n numbers in the array that equals be the largest sum
    public static int largestSum(int[] numbers, int n) {

        if (n > numbers.length) {
            throw new IllegalArgumentException("n cannot be larger than the size of the array");
        }

        int sum = 0;
        Arrays.sort(numbers);
        for (int i = numbers.length - 1; i >  numbers.length - 1 - n; i--) {
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, -1, 2, -3, 0};
//        int[] numbers = {};

        int n = 4;
//        int n = 7;

        try {
            System.out.println(largestSum(numbers, n));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
