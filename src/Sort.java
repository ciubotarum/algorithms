public class Sort {

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {

            int pi = partition(nums, low, high);

            quickSort(nums, low,pi  - 1);
            quickSort(nums,pi + 1 ,high);
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
        int size = nums.length;
        int temp = 0;

        System.out.println("Before sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        // Bubble sort
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size - i - 1; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    temp = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = temp;
//                }
//            }
//        }

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

//        quickSort(nums, 0, size - 1);
        mergeSort(nums, 0, size - 1);

        System.out.println("\nAfter sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
