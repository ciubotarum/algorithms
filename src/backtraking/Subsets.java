package backtraking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // Given an integer array of unique elements, return all possible subsets.
    // The solution set must not contain duplicate subsets.
    // Return the solution in any order.

    // Example 1:
    // Input: nums = [1, 2, 3]
    // Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    // Example 2:
    // Input: nums = [0]
    // Output: [[0],[0]]
    // Backtracking function to generate all subsets
    private static void backtrack(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(currentSubset));

        // Explore all possible subsets by including each element
        for (int i = start; i < nums.length; i++) {
            // Include the current element
            currentSubset.add(nums[i]);

            // Recurse with the current element included
            backtrack(nums, i + 1, currentSubset, result);

            // Backtrack to explore subsets without the current element
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    // Main function to generate all subsets
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {0};

        System.out.println("Subsets for [1, 2, 3]: " + subsets(nums1));
        System.out.println("Subsets for [0]: " + subsets(nums2));
    }

}
