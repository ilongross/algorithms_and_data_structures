package structures.stack.training;

public class MyStack<T> {

    private Node<T> head;

    public void push(T t) {
        Node<T> newNode = new Node<>(t);
        newNode.next = head;
        head = newNode;
    }

    public T pop() {
        if(head == null)
            return null;
        T value = head.value;
        head  = head.next;
        return value;
    }

    public T peek() {
        return head.value;
    }

    public int size() {
        int size = 0;
        if(head == null)
            return size;
        Node<T> currentNode = head;
        while(currentNode.next != null) {
            ++size;
            currentNode = currentNode.next;
        }
        return ++size;
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
            return value + " " + (next != null ? next : "") + " ";
        }
    }

    @Override
    public String toString() {
        return "MyStack: " + head;
    }
}
