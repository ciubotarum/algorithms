package divideandconquer;

public class FindMaximumElement {

    public static Integer findMaximumElement(int[] lst) {
        if (lst.length == 0) {
            return null;
        }
        return findMax(0, lst.length - 1, lst);
    }

    public static Integer findMax(int i, int j, int[] lst) {
        if (i == j) {
            return lst[i];
        }
        int mid = (i + j) / 2;
        return Math.max(
                findMax(i, mid, lst),
                findMax(mid + 1, j, lst)
        );

    }
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
//        int[] array = {};

        System.out.println(findMaximumElement(array));
    }
}
