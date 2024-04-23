import java.lang.reflect.Array;

public class DynamicArray {
    private int[] items;
    private int count;
    public DynamicArray(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
    public void insert(int item) {
        // If the array is full, resize it
        if (items.length == count) {
            // Create a new array (twice the size)
            int[] newItems = new int[2*count];
            // Copy all existing items
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            // Set "items" to this new array
            items = newItems;
        }
        // Add the new item at the end
        items[count++] = item;
        // count++
    }

    public void removeAt(int index) {
        // Validate the index
        if (index >= count || index < 0) {
            throw new IllegalArgumentException();
        }
        // Shift the items to the left to fill the hole
        for (int i = index; i < count; i++) {
            items[i] = items[i+1];
        }
        count--;
    }
    public int indexOf(int item) {
        // If we find it, return index
        // Otherwise, return -1
        // O(n)
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        DynamicArray numbers = new DynamicArray(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.removeAt(0);
        numbers.print();
        System.out.println(numbers.indexOf(30));
    }
}
