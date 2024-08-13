package search;

public class LinearSearch {
    public static int linearSearch(int[] nums, int target) {
        int steps = 0;
        for (int i = 0; i < nums.length; i++) {
            steps++;
            if (nums[i] == target) {
                System.out.println("Steps taken by Linear : " + steps);
                return i;
            }
        }
        System.out.println("Steps taken by Linear : " + steps);
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 9, 11, 13, 17 };
        int target = 11;

//        int[] nums = new int[1000];
//        int target = 900;

        int result = linearSearch(nums, target);

        if (result != -1) {
            System.out.println("Element found at Index: " + result);
        } else {
            System.out.println("Element not found!");
        }

    }
}
