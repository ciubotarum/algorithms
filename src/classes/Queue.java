package classes;

// First In First Out
public class Queue {
    int[] queue = new int[5];
    int size;
    int front;
    int rear;

    public void enQueue(int data) {
        if (!isFull()) {
            queue[rear] = data;
            rear = (rear + 1) % 5;
            size++;
        } else {
            System.out.println("classes.Queue is Full");
        }

    }

    public void show() {
        System.out.println("Elements : ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % 5] + " ");
        }
        System.out.println();
        for (int n : queue) {
            System.out.print(n + " ");
        }
    }

    public int deQueue() {
        int data = queue[front];
        if (!isEmpty()) {
            front = (front + 1) % 5;
            size -= 1;
        } else {
            System.out.println("classes.Queue is empty");
        }


        return data;
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return getSize() == 0;
    }
    public boolean isFull() {
        return getSize() == 5;
    }


    public static void main(String[] args) {
        Queue q = new Queue();
//        q.enQueue(5);
//        q.enQueue(2);
//        q.enQueue(7);
//        q.enQueue(3);

        // delete the first element
        q.deQueue();
//        q.deQueue();

//        q.enQueue(9);
//        q.enQueue(1);

//        q.enQueue(19);
//        q.enQueue(15);

        System.out.println(q.isFull());

        System.out.println(q.isEmpty());

        System.out.println("Size " + q.getSize());


        q.show();
    }
}
