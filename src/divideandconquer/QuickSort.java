package divideandconquer;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {

            int pi = partition(nums, low, high);

            quickSort(nums, low, pi - 1);
            quickSort(nums, pi + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {8, 5, 111, 9, 1, 6, 7, 75};
//        int[] nums = {10, 80, 30, 90, 40};

        int size = nums.length;

        quickSort(nums, 0, size - 1);

        System.out.println(Arrays.toString(nums));
    }
}
