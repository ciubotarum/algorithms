package backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllTriplets {
    //    Given an unsorted integer array, print all triplets in it with sum less than or equal to a given number.
//
//    For example,
//
//    Input: nums = [ 2, 7, 4, 9, 5, 1, 3 ]
//    sum = 10
//    Output: Triplets are (1, 2, 3)(1, 2, 4)(1, 2, 5)(1, 2, 7)(1, 3, 4)(1, 3, 5)(1, 4, 5)(2, 3, 4)(2, 3, 5)


    public static void findAllTriplets(int[] nums, int target) {
        Arrays.sort(nums);

        backtracking(nums, target, 0, new ArrayList<>());

    }

    public static int sum(List<Integer> currentArray) {
        if (currentArray.isEmpty()) {
            return 0;
        }
        return currentArray.stream().reduce(Integer::sum).get();
    }

    public static void backtracking(int[] nums, int target, int start, List<Integer> currentArray) {

        if (currentArray.size() == 3) {
            if (sum(currentArray) <= target) {
                System.out.println(currentArray);
            }
            return;
        }

        if (sum(currentArray) > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            currentArray.add(nums[i]);

            backtracking(nums, target,i + 1, currentArray);

            currentArray.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 9, 5, 1, 3};
        int target = 10;

        findAllTriplets(nums, target);
    }
}
