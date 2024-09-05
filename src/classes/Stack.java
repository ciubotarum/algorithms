package classes;

public class Stack {
    int[] stack = new int[5];
    int top = 0;
    public void push(int data) {
        if (top == 5) {
            System.out.println("classes.Stack is full");
        }
        stack[top] = data;
        top++;
    }

    public void show() {
        for (int n : stack) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public int pop() {
        int data = 0;
        if (isEmpty()) {
            System.out.println("classes.Stack is empty");
        } else {
            top--;
            data = stack[top];
            stack[top] = 0;
        }

        return data;
    }
    public int peek() {
        int data;
        data = stack[top - 1];

        return data;
    }

    public int size() {
        return top;
    }
    public boolean isEmpty() {
        return top <= 0;
    }
    public static void main(String[] args) {
        Stack nums = new Stack();

        // Add a new value
        nums.push(15);
        nums.show();
        nums.push(8);
        nums.show();

        // Take the last number
//        System.out.println(nums.peek());

        nums.push(10);
        nums.show();
//        nums.push(7);
//        nums.show();
//        nums.push(17);
//        nums.show();
//        nums.push(77);
//        nums.show();

        // Remove the value from the stack
        System.out.println(nums.pop());

        // Print the size of the stack
        System.out.println("Size is " + nums.size());

        // Check if is empty
        System.out.println("Empty = " + nums.isEmpty());

        nums.show();
    }
}
