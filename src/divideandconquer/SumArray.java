package divideandconquer;

public class SumArray {
    public static int sumArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        int leftSum = sumArray(nums, left, mid);
        int rightSum = sumArray(nums, mid + 1, right);


        return leftSum + rightSum;
    }


    public static void main(String[] args) {

        int[] nums = {8, 5, 111, 9, 1, 6, 7, 75};

        int left = 0;
        int right = nums.length - 1;

        System.out.println(sumArray(nums, left, right));
    }
}
