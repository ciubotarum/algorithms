public class DynamicStack {
    int capacity = 2;
    int[] stack = new int[capacity];
    int top = 0;
    public void push(int data) {
        if (size() == capacity) {
            expand();
        }

        stack[top] = data;
        top++;
    }

    private void expand() {
        int length = size();
        int newStack[] = new int[capacity*2];
        // copy all the values to the new array
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        capacity *= 2;
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
            System.out.println("Stack is empty");
        } else {
            top--;
            data = stack[top];
            stack[top] = 0;
            shrink();
        }

        return data;
    }

    private void shrink() {
        int length = size();
        if (length <= (capacity / 2) / 2) {
            capacity = capacity / 2;
        }
        int[] newStack = new int[capacity];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
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
        DynamicStack nums = new DynamicStack();

        // Add a new value
        nums.push(15);
        nums.show();
        nums.push(8);
        nums.show();
        nums.push(10);
        nums.show();
        nums.push(7);
        nums.show();
        nums.push(17);
        nums.show();
        nums.push(77);
        nums.show();

        nums.pop();
        nums.show();
        nums.pop();
        nums.show();
        nums.pop();
        nums.show();
        nums.pop();
        nums.show();


    }
}

