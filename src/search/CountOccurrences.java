package search;

import static java.util.spi.ToolProvider.findFirst;

public class CountOccurrences {
//    Given a sorted integer array containing duplicates, count occurrences of a given number.
//    If the element is not found in the array, report that as well.

//    For example,

//    Input:  nums[] = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
//    target = 5
//    Output: Target 5 occurs 3 times

    //    Input:  nums[] = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
//    target = 6
//    Output: Target 6 occurs 2 times
    public static int countOccurrences(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return findLast(nums, target, left, right) - findFirst(nums, target, left, right) + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return -1;
    }

    private static int findLast(int[] nums, int target, int left, int right) {
        if (nums[right] == target) {
            return right;
        }

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                if (nums[mid] == nums[mid + 1]) {
                    return findLast(nums, target, mid+1, right);
                } else {
                    return mid;
                }
            } else if (nums[mid] > target) {
                return findLast(nums, target, left, mid - 1);
            } else {
                return findLast(nums, target, mid + 1, right);
            }
        }

        return -1;
    }

    private static int findFirst(int[] nums, int target, int left, int right) {

        if (nums[left] == target) {
            return left;
        }

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    return findFirst(nums, target, left, mid - 1);
                }
            } else if (nums[mid] > target) {
                return findFirst(nums, target, left, mid - 1);
            } else {
                return findFirst(nums, target, mid + 1, right);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
//        int[] nums[] = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};

//        int target = 5;
        int target = 6;

        int left = 0;
        int right = nums.length - 1;

        System.out.println("Target " + target + " occurs " + countOccurrences(nums, target) + " times");
    }
}
