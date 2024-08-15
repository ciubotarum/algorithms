package divideandconquer;

import java.util.Arrays;

public class MergeSort {
    private static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);

            merge(nums, l, mid, r);
        }
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] lArr = new int[n1];
        int[] rArr = new int[n2];

        for (int x = 0; x < n1; x++) {
            lArr[x] = nums[l + x];
        }
        for (int x = 0; x < n2; x++) {
            rArr[x] = nums[mid + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (lArr[i] <= rArr[j]) {
                nums[k] = lArr[i];
                i++;
            } else {
                nums[k] = rArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = lArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            nums[k] = rArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        //        int[] nums = { 6, 5, 2, 8, 9, 4 };
//        int[] nums = { 3, 5, 1, 4, 6, 2 };
        int[] nums = { 8, 5, 111, 9, 1, 6, 7, 75 };

        int l = 0;
        int r = nums.length - 1;

        mergeSort(nums, l, r);
        System.out.println(Arrays.toString(nums));
    }
}
