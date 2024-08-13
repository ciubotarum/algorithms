package search;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target, int left, int right) {
        // 5, 7, 9, 11, 13

        int steps = 0;

        // the starting point
//        int left = 0;
        // the ending point
//        int right = nums.length - 1;

//        while (left <= right) {
//            steps++;
//            int mid = (left + right) / 2;
//
//            if (nums[mid] == target) {
//                System.out.println("Steps taken by Binary : " + steps);
//                return mid;
//            } else if (nums[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }

        // recursive
        if (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return binarySearch(nums, target, mid + 1, right);
            } else {
                return binarySearch(nums, target, left, mid - 1);
            }
        }

//        System.out.println("Steps taken by Binary : " + steps);
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = { 5, 7, 9, 11, 13, 17 };
        int target = 11;

//        int[] nums = new int[1000];
//        int target = 900;

//        int result = binarySearch(nums, target);
        int result = binarySearch(nums, target, 0, nums.length - 1);

        if (result != -1) {
            System.out.println("Element found at Index: " + result);
        } else {
            System.out.println("Element not found!");
        }

    }
}
