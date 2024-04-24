import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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

        // _______________________________________________________________
         // Initialize an array list
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(0);
        list.indexOf(20);
        list.contains(20);
        list.size();

        // Convert the Arraylist to an Array
        list.toArray();

        System.out.println(list);

        //___________________________________________________________________
        LinkedList list1 = new LinkedList();
        list1.addLast(10);
        list1.addLast(20);
        list1.addLast(30);
        list1.addFirst(5);

        list1.removeLast();
        list1.removeFirst();

        System.out.println(list1.contains(10));
        System.out.println(list1.indexOf(10));
        System.out.println(list1.size());
        System.out.println(list1);

        var array = list1.toArray();
        System.out.println(Arrays.toString(array));


    }
}