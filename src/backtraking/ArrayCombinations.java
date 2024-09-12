package backtraking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayCombinations {
    //    In this Kata, you will be given an array of arrays and your task will be to return the number of unique
//    arrays that can be formed by picking exactly one element from each subarray.
//
//    For example: solve([[1,2],[4],[5,6]]) = 4, because it results in only 4 possibilites.
//    They are [1,4,5],[1,4,6],[2,4,5],[2,4,6].
//
//    Make sure that you don't count duplicates; for example solve([[1,2],[4,4],[5,6,6]]) = 4,
//    since the extra outcomes are just duplicates.

    public static int solve(final List<List<Integer>> data) {
        Set<List<Integer>> solution = new HashSet<>();
        backtracking(data, 0, new ArrayList<>(), solution);
        return solution.size();

        // Another ways to solve the problem

//        return data.stream()
//                .mapToInt(set -> (int)set.stream().distinct().count())
//                .reduce(1, (a,b) -> a * b);

        // or

//        return data.stream()
//                .map(HashSet::new)
//                .mapToInt(Set::size)
//                .reduce(1, (a, b) -> a * b);
    }

    public static void backtracking(final List<List<Integer>> data, int start, ArrayList<Integer> combinations, Set<List<Integer>> uniqueCombinations) {

        if (start == data.size()) {
            uniqueCombinations.add(new ArrayList<>(combinations));
            return;
        }
        for (Integer number : new HashSet<>(data.get(start))) {

            combinations.add(number);
            backtracking(data, start + 1, combinations, uniqueCombinations);
            combinations.remove(combinations.size() - 1);
        }
    }



    public static void main(String[] args) {
        // Output : 4
//        List<List<Integer>> data = List.of(
//                List.of(1, 2),
//                List.of(4),
//                List.of(5, 6)
//        );

        // Output : 4
//        List<List<Integer>> data = List.of(
//                List.of(1,2),
//                List.of(4, 4),
//                List.of(5,6,6)
//        );

        // Output : 8
        List<List<Integer>> data = List.of(
                List.of(1,2),
                List.of(3,4),
                List.of(5,6)
        );

//         Output : 72
//        List<List<Integer>> data = List.of(
//                List.of(1,2,3),
//                List.of(3,4,6,6,7),
//                List.of(8,9,10,12,5,6)
//        );


        System.out.println(solve(data));
    }
}
