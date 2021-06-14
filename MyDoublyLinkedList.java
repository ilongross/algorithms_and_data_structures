package backend;

public class MyDoublyLinkedList<T extends Comparable> {

    private Node<T> head;
    private Node<T> tail;

    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertFirst(T value) {
        Node<T> newNode = new Node<T>(value);
        if(isEmpty())
            tail = newNode;
        else
            head.previous = newNode;
        newNode.next = head;
        head = newNode;
    }
    public void insertLast(T value) {
        Node<T> newNode = new Node<T>(value);
        if(isEmpty())
            head = newNode;
        else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
    }

    public T deleteFirst() {
        Node<T> tmp = head;
        if(head.next == null)
            tail = null;
        else
            head.next.previous = null;
        head = head.next;
        return tmp.value;
    }
    public T deleteLast() {
        Node<T> tmp = tail;
        if(head.next == null)
            head = null;
        else
            tail.previous.previous = null;
        tail = tail.previous;
        return tmp.value;
    }

    public boolean insertAfter(T targetElem, T newElem) {
        Node<T> current = tail;
        while(current.value != targetElem) {
            current = current.next;
            if(current == null)
                return false;
        }
        Node<T> newNode = new Node<T>(newElem);
        if(current == tail) {
            newNode.next = null;
            tail = newNode;
        }
        else {
            newNode.next = current.next;
            current.next.previous = newNode;
        }
        newNode.previous = current;
        current.next = newNode;
        return true;
    }
    public T deleteElem(T targetElem) {
        Node<T> current = head;
        while(current.value != targetElem) {
            current = current.next;
            if(current == null)
                return null;
        }
        if(current == head)
            head = current.next;
        else
            current.previous.next = current.next;

        if(current == tail)
            tail = current.previous;
        else
            current.next.previous = current.previous;
        return current.value;
    }

    public void showForward() {
        System.out.println("List: first-->last");
        Node<T> current = head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println(" ");
    }

    public void showBackward() {
        System.out.println("List: last-->first");
        Node<T> current = tail;
        while(current != null) {
            System.out.println(current.value);
            current = current.previous;
        }
        System.out.println(" ");
    }

    public boolean isEmpty() {
        return head == null;
    }

    private static class Node<T extends Comparable> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Node(" + value + " " + next + ") ";
        }
    }

    @Override
    public String toString() {
        return "MyDoublyLinkedList(" + "head=" + head + ")";
    }
}
