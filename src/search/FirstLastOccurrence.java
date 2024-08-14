package search;

public class FirstLastOccurrence {
//    Given a sorted integer array, find the index of a given number’s first or last occurrence.
//    If the element is not present in the array, report that as well.

//    For example,

//    Input: nums = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
//    target = 5
//    Output: The first occurrence of element 5 is located at index 1
//    The last occurrence of element 5 is located at index 3
//
//    Input: nums = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
//    target = 4
//    Output: Element not found in the array
    public static int firstOccurrence(int[] nums, int target, int left, int right) {

        if (nums[left] == target) {
            return left;
        }

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    return firstOccurrence(nums, target, left, mid-1);
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static int lastOccurrence(int[] nums, int target, int left, int right) {

        if (nums[right] == target) {
            return right;
        }

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                if (nums[mid] == nums[mid + 1]) {
                    return lastOccurrence(nums, target, mid+1, right);
                } else {
                    return mid;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {

//        int[] nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int[] nums = {2, 2, 5, 5, 6, 6, 8, 9, 9, 9};

        int target = 2;
//        int target = 4;

        int left = 0;
        int right = nums.length - 1;

        if (firstOccurrence(nums, target, left, right) == -1) {
            System.out.println("Element not found in the array");
        } else {
            System.out.println("The first occurrence of element " + target + " is located at index "  + firstOccurrence(nums, target, left, right));
            System.out.println("The last occurrence of element " + target + " is located at index "  + lastOccurrence(nums, target, left, right));
        }

    }
}
