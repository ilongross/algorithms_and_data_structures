package structures.queue.training;

public class MyQueue<T> {

    private Node<T> head;
    private Node<T> tail;

    public void enqueue (T t) {
        Node<T> newNode = new Node<>(t);
        if(head == null) {
            head = newNode;
        }
        if(tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void dequeue () {
        head = head.next;
        if(head == null)
            tail = null;
    }

    public T peek() {
        return (head != null ? head.value : null);
    }

    public int size() {
        int size = 0;
        if(head == null)
            return 0;
        if(tail != null)
            size = 1;
            Node<T> currentNode = head;
        while(currentNode.next != null) {
            ++size;
            currentNode = currentNode.next;
        }
        return  size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;
        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + " " + (next != null ? next : "");
        }
    }

    @Override
    public String toString() {
        return "MyQueue: "+ head;
    }
}
