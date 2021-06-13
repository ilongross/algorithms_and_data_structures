package backend;

public class MyTwoSideList<T> {
    private Node<T> head;
    private Node<T> tail;

    public void insertFirst(T value) {
        Node<T> newNode = new Node<T>(value);
        if(isEmpty())
            tail = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(T t) {
        Node<T> newNode = new Node<T>(t);
        if(isEmpty())
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
    }

    public T deleteFirst() {
        T tmp = head.value;
        if(head.next == null)
            tail = null;
        head = head.next;
        return tmp;
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
            return "Node(" + value +
                    ", next=" + next + ")";
        }
    }

    @Override
    public String toString() {
        return "TwoSideList(" + head + ")";
    }
}
