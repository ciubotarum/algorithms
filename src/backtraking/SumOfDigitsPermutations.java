package backtraking;

import java.util.ArrayList;
import java.util.List;

public class SumOfDigitsPermutations {
//    Scrieți un program care citește un număr natural n cu cifre distincte și care să calculeze
//    și să afișeze suma S a tuturor numerelor obținute prin rearanjarea cifrelor lui n.

    // Example:
    // Input: 123
    // Output: 1332
    // Numere obținute din 123 prin amestecarea cifrelor sunt 123, 132, 213, 231, 312 și 321, iar suma lor este 1332.

    public static List<Integer> allNumbersOfPermutations(int[] nums) {
        List<Integer> solution = new ArrayList<>();
        permutations(nums, 0, new ArrayList<>(), solution);
        return solution;
    }

    public static void permutations(int[] nums, int start, List<Integer> currentList, List<Integer> solution) {
        if (start == nums.length ) {
            StringBuilder builder = new StringBuilder();

            for (int i = nums.length - 1; i >= 0 ; i--) {
                builder.append(currentList.get(i));
            }
            Integer integer = Integer.valueOf(builder.toString());
            solution.add(integer);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            currentList.add(nums[i]);
            swap(nums, start, i);
            permutations(nums, start + 1, currentList, solution);
            swap(nums, start, i);
            currentList.removeLast();
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] digitsOfNumber(int number) {
        List<Integer> arr = new ArrayList<>();
        while (number > 0) {
            int digit = number % 10;
            arr.add(digit);
            number = number / 10;
        }
        int[] nums = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
        }
        return nums;
    }


    public static void main(String[] args) {
        int number = 123;

        int[] nums = digitsOfNumber(number);

        List<Integer> permutations = allNumbersOfPermutations(nums);

        int sum = permutations.stream().reduce(Integer::sum).get();
        System.out.println(sum);

    }
}
