package search;

public class SearchCircularlySortedArray {
//    Given a circularly sorted integer array, search an element in it.
//    Assume there are no duplicates in the array, and the rotation is in the anti-clockwise direction.

//    For example,

    //    Input: nums = [8, 9, 10, 2, 5, 6]
//    target = 10
//    Output: Element found at index 2
//
//    Input: nums = [9, 10, 2, 5, 6, 8]
//    target = 5
//    Output: Element found at index 3
    public static int circularSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {8, 9, 10, 2, 5, 6};
        int[] nums = {9, 10, 2, 5, 6, 8};

        int target = 10;
//        int target = 5;

        System.out.println("Element " + target + " is found at index " + circularSearch(nums, target));
    }
}
