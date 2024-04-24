import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void addFirst(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            // node pointing to our first node
            node.next = first;
            first = node;
        }

    }
    private boolean isEmpty() {
        return first == null;
    }
    public void addLast(int item) {
        // rap item in a Node object
//        Node node = new Node();  // or we can write
        var node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;

    }
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }
    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
    }
    public void deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
            return;
        }
        var previous = getPrevious(last);
        last = previous;
        last.next = null;
    }
    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
//        java.util.LinkedList<String> x = new java.util.LinkedList<>();
//        x.removeFirst();
        var list = new LinkedList();
        // addFirst
        list.addFirst(5);
        // addLast
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        // deleteFirst
        list.deleteFirst();
        // deleteLast
        list.deleteLast();
        // contains
        System.out.println(list.contains(30));
        // indexOf
        System.out.println(list.indexOf(100));
    }


}
