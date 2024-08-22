package greedy;

public class MaximumNumberOfActivities {
//    You are given n activities with their start and finish times. Select the maximum number of activities
//    that can be performed by a single person, assuming that a person can only work on a single activity at a time.

    // Examples:
//    Input: start[]  =  {10, 12, 20},
//           finish[] =  {20, 25, 30}
//    Output: 0
//    Explanation: A person can perform at most one activities.
//
//    Input: start[]  =  {1, 3, 0, 5, 8, 5},
//           finish[] =  {2, 4, 6, 7, 9, 9};
//    Output: 0 1 3 4
//    Explanation: A person can perform at most four activities. The
//    maximum set of activities that can be executed
//    is {0, 1, 3, 4} [ These are indexes in start[] and finish[]

    public static void maximumNumberOfActivities(int[] start, int[] end) {

        int i = 0;
        System.out.print(i + " ");
        for (int j = 1; j < start.length; j++) {

            if (start[j] >= end[i]) {
//                System.out.println(start[i]);
                System.out.print(j + " ");
                i = j;
            }

        }
    }

    public static void main(String[] args) {
        int[] start  =  {1, 3, 0, 5, 8, 5};
        int[] finish =  {2, 4, 6, 7, 9, 9};

//        int[] start  =  {10, 12, 20};
//        int[] finish =  {20, 25, 30};

        maximumNumberOfActivities(start, finish);
    }
}
