package backtraking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsLexicographicOrder {
//    Se citeşte un număr natural nenul n. Să se afişeze, în ordine lexicografică, permutările mulţimii {1,2,..,n}.

//    Example:
//    Input: 3
//    Output: 1 2 3
//            1 3 2
//            2 1 3
//            2 3 1
//            3 1 2
//            3 2 1
public static void allPermutations(int[] nums) {
    List<List<Integer>> solution = new ArrayList<>();
    backtracking(nums, 0, new ArrayList<>(), solution);

    solution.sort((x, y) -> {
        for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
            if (x.get(i) != y.get(i)) {
                return x.get(i) - y.get(i);
            }
        }
        return x.size() - y.size();
    });

    solution.stream().forEach(System.out::println);

}

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void backtracking(int[] nums, int start, List<Integer> currentArray, List<List<Integer>> solution) {

        if (start == nums.length) {
            solution.add(new ArrayList<>(currentArray));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            currentArray.add(nums[i]);
            swap(nums, start, i);
            backtracking(nums, start + 1, currentArray, solution);
            swap(nums, start, i);
            currentArray.removeLast();
        }
    }

    public static void main(String[] args) {

        int number = 3;
        int[] numbers = new int[number];
        for (int i = 0; i < number; ++i) {
            numbers[i] = i + 1;
        }

        allPermutations(numbers);
    }
}
