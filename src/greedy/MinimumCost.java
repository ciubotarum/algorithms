package greedy;

import java.util.PriorityQueue;

public class MinimumCost {
//    Given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost,
//    such that the cost to connect two ropes is equal to the sum of their lengths.
//
//    Examples:
//
//    Input: arr[] = {4,3,2,6} , N = 4
//    Output: 29
//    Explanation:
//
//    First, connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6, and 5.
//    Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
//    Finally, connect the two ropes and all ropes have connected.

//    Input: arr[] = {1, 2, 3} , N = 3
//    Output: 9
//    Explanation:
//
//    First, connect ropes of lengths 1 and 2. Now we have two ropes of lengths 3 and 3.
//    Finally, connect the two ropes and all ropes have connected.

    public static int minimumCost(int[] arr, int N) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(arr[i]);
        }

        int sum = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            sum += first + second;
            pq.add(first+second);
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] arr = {4, 3, 2, 6};
//        int N = 4;

        int[] arr = {1, 2, 3};
        int N = 3;

        System.out.println(minimumCost(arr, N));
    }
}
