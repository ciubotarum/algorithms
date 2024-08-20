package backtraking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
//    _Given a list of distinct positive numbers, find all combinations that add up to a given number.
//
//    Input: [1, 2, 3, 4],
//    target = 5
//    Output: [[2, 3], [1, 4]]_

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> solution = new ArrayList<>();
        backtracking(nums, target, 0, new ArrayList<>(), solution);

        return solution;
    }


    public static int listSum(List<Integer> currentList){
        if (currentList.isEmpty()){
            return 0;
        }
        return currentList.stream().reduce(Integer::sum).get();
    }

    public static void backtracking(int[] nums, int target, int start, List<Integer> currentList, List<List<Integer>> solution) {
        int sum = listSum(currentList);

        if (sum == target) {
            solution.add(new ArrayList<>(currentList));
            return;
        }

        if (sum > target){
            return;
        }


        for (int i = start; i < nums.length; i++) {
            currentList.add(nums[i]);

            backtracking(nums, target, i + 1, currentList, solution);

            currentList.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int target = 5;

        System.out.println(combinationSum(nums, target));
    }
}
