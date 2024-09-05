package classes;

public class Sort {

    public static void main(String[] args) {
//        int[] nums = { 6, 5, 2, 8, 9, 4 };
//        int[] nums = { 3, 5, 1, 4, 6, 2 };
        int[] nums = {8, 5, 111, 9, 1, 6, 7, 75};
        int size = nums.length;
        int temp = 0;

        System.out.println("Before sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        // Bubble sort
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        // Selection sort
//        int minIndex = -1;
//        for (int i = 0; i < size - 1; i++) {
//            minIndex = i;
//            for (int j = i + 1; j < size; j++) {
//                if (nums[minIndex] > nums[j]) {
//                    minIndex = j;
//                }
//            }
//            temp = nums[minIndex];
//            nums[minIndex] = nums[i];
//            nums[i] = temp;
//
//            System.out.println();
//
//            for (int num : nums) {
//                System.out.print(num + " ");
//            }
//        }

        // Insertion sort
//        for (int i = 1; i < size; i++) {
//            int key = nums[i];
//            int j = i - 1;
//
//            while (j >= 0 && nums[j] > key) {
//                nums[j + 1] = nums[j];
//                j--;
//            }
//            nums[j + 1] = key;
//        }



        System.out.println("\nAfter sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
