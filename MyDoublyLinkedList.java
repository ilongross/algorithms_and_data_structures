package backend;

public class MyDoublyLinkedList<T extends Comparable> {

    private Node<T> head;
    private Node<T> tail;

    public void addFirst(T value) {
        Node<T> newNode = new Node<T>(value);
        if(isEmpty())
            tail = newNode;
        else {
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;
    }
    public void addLast(T value) {
        Node<T> newNode = new Node<T>(value);
        if(isEmpty())
            head = newNode;
        else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
    }
    public boolean addAfter(T targetElem, T newElem) {
        Node<T> current = new Node<T>(targetElem);
        while(current.next != null) {
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
            tail.previous.next = null;
        tail = tail.previous;
        return tmp.value;
    }
    public boolean deleteElem(T value) {
        Node<T> waste = new Node<T>(value);
        Node<T> current = head;
        while(current != null) {
            current = current.next;
            if(current == null)
                return false;
            if(current.value == waste.value) {
                current.next = waste.next;
                waste.next.previous = waste.previous;
                return true;
            }
        }
        return false;
    }

    public T getFirst() {
        return head.value;
    }
    public T getLast() {
        return tail.value;
    }
    public boolean contains(T targetElem) {
        Node<T> target = new Node<T>(targetElem);
        Node<T> current = head;
        while(current != null) {
            if(current.value == target.value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clearList() {
        Node<T> current = head;
        int i = 0;
        while(current != null) {
            deleteFirst();
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        int size = 0;
        if(head == null)
            return 0;
        Node<T> current = head;
        while(current != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    public void showForward() {
        Node<T> current = head;
        System.out.print("Doubly Forward (first-->last): ");
        while(current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    public void showBackward() {
        Node<T> current = tail;
        System.out.print("Doubly Backward  (last-->first): ");
        while(current != null) {
            System.out.print(current.value + " ");
            current = current.previous;
        }
        System.out.println();
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
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    ", previous=" + previous +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestDoublyLinkedList(" +
                "head=" + head + ")";
    }
}
