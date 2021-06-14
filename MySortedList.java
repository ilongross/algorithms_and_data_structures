package backend;

public class MySortedList<T extends Comparable> {

    private Node<T> head;

    public MySortedList() {
        this.head = null;
    }

    public void insert(T value) {
        Node<T> newNode = new Node<T>(value);
        Node<T> previous = null;
        Node<T> current = head;

        while((current != null) && (value.compareTo(current.value) > 0)) {
            previous = current;
            current = current.next;
        }
        if(previous == null)
            head = newNode;
        else
            previous.next = newNode;
        newNode.next = current;
    }

    public T extractFirst() {
        Node<T> tmp = head;
        head = head.next;
        return tmp.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Node(" +
                    "value=" + value +
                    ", next=" + next + ")";
        }
    }

    @Override
    public String toString() {
        return "SortedList(" +
                "head=" + head + ")";
    }
}
