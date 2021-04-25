package structures.linked_list.training;

public class MyLinkedList<T> {

    private Node<T> head;

    public void addFirst(T t) {
        Node<T> firstNode = new Node<>(t);
        firstNode.next = head;
        head = firstNode;
    }

    public void addLast(T t) {
        if(head == null) {
            head = new Node<>(t);
            return;
        }
        Node<T> currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(t);
    }

    public void remove(T t) {
        if(head.next == null) {
            head = null;
            return;
        }
        if(head.value == t) {
            head = head.next;
        }
        Node<T> currentNode = head;
        while(currentNode.next != null) {
            if(currentNode.next.value == t) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public int get(T t) {
        if(head == null)
            return -1;
        Node<T> currentNode = head;
        int result = 0;
        while(currentNode != null) {
            ++result;
            if(currentNode.next.value == t)
                return result;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int size = 0;
        if(head == null)
            return size;
        Node<T> currentNode = head;
        while(currentNode != null) {
            ++size;
            currentNode = currentNode.next;
        }
        return size;
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;
        public Node(T value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return value + " " + (next != null ? next : "") + "" ;
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList: " + head + " ";
    }
}
