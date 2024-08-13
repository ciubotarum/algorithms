package divideandconquer;

public class FindMinimumElement {

    public static Integer findMinimumElement(int[] lst) {
        if (lst.length == 0) {
            return null;
        }
        return findMin(0, lst.length - 1, lst);
    }

    public static Integer findMin(int i, int j, int[] lst) {
        if (i == j) {
            return lst[i];
        }
        int mid = (i + j) / 2;
        return Math.min(
                findMin(i, mid, lst),
                findMin(mid + 1, j, lst)
        );

    }
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
//        int[] array = {};

        System.out.println(findMinimumElement(array));
    }
}
