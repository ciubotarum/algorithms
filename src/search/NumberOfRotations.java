package search;

public class NumberOfRotations {
//    Find the number of rotations in a circularly sorted array
//    Given a circularly sorted integer array, find the total number of times the array is rotated.
//    Assume there are no duplicates in the array, and the rotation is in the anti-clockwise direction.

//    For example,
//
//    Input:  nums = [8, 9, 10, 2, 5, 6]
//    Output: The array is rotated 3 times

//    Input:  nums = [2, 5, 6, 8, 9, 10]
//    Output: The array is rotated 0 times

    public static int numberOfRotations (int[] nums, int left, int right) {
//        If we carefully analyze the problem, we can see that the total number of rotations is equal to
//        the total number of elements before the minimum element, or the index of the minimum element.

        if (nums[left] <= nums[right]) {
            return left;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the minimum element (rotation point)
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            if (nums[mid] < nums[mid - 1]) {
                return mid;
            }

            // Decide whether to go left or right
            if (nums[mid] >= nums[left]) {
                left = mid + 1;  // The left part is sorted, go right
            } else {
                right = mid - 1; // The right part is sorted, go left
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 5, 6, 8, 9, 10};
//        int[] nums = {8, 9, 10, 2, 5, 6};
//        int[] nums = { 8, 9, 10, 1, 2, 3, 4, 5, 6, 7 };
        int[] nums = { 2, 3, 4, 5, 1 };

        System.out.println("Array is rotated " + numberOfRotations(nums, 0, nums.length - 1) + " times");
    }
}
