package backtraking;

public class StringPermutation {
    // Given a string, print all the permutations which do not contain "AB" as a substring.

    // Example:

    // Input: str = "ABC"
    // Output: ACB, BAC, BCA, CBA

    // Helper function to swap characters at two positions
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Recursive function to generate permutations
    private static void generatePermutations(char[] arr, int currentIndex) {
        if (currentIndex == arr.length - 1) {
            String permutation = new String(arr);
            // Check if the permutation contains "AB" as a substring
            if (!permutation.contains("AB")) {
                System.out.println(permutation);
            }
            return;
        }

        for (int i = currentIndex; i < arr.length; i++) {
            // Swap the current element with the element at the currentIndex
            swap(arr, currentIndex, i);
            // Recur for the next index
            generatePermutations(arr, currentIndex + 1);
            // Backtrack to restore the original order
            swap(arr, currentIndex, i);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        generatePermutations(str.toCharArray(), 0);
    }
}
