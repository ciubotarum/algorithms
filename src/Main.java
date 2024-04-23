import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Arrays have a fixed size

        // Declare an array of 3 (by default it will be an array of zero
//        int[] numbers = new int[3];

        // Change the values of the array
//        numbers[0] = 10;
//        numbers[1] = 20;
//        numbers[2] = 30;

        // Best to declare and initialize an array
        int[] numbers = { 10, 20, 30 };

        // Print the length of the array
        System.out.println(numbers.length);

        // Print the array of numbers
        System.out.println(Arrays.toString(numbers));


    }
}