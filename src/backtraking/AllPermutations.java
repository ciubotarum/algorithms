package backtraking;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {

    //    Given a collection of distinct integers, return all possible permutations of them.
//    Input: [1, 2, 3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//    This becomes simple once our intuition is clear. To form a permutation, there are 2 important principles:
//
//    1. Include all the elements - This forms the stopping condition.
//    2. No element can be included more than once. This means that at any state, our possible moves include only
//    the elements we have not included before.
    public static List<List<Integer>> allPermutations(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), solution);

        return solution;
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
        int[] nums = {1, 2, 3};
        
        System.out.println(allPermutations(nums));
    }
}
