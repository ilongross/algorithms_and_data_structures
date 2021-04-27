package structures.stack.array_stack;

import java.util.Arrays;

public class MyArrayStack<T> {

    private int size;
    private T [] elements;
    private int top;

    public MyArrayStack(int size) {
        this.size = size;
        this.elements = (T[]) new Object[size];
        this.top = -1;
    }

    public void push(T t) {
        elements[++top] = t;
    }
    public T pop() {
        elements[top] = null;
        int index = top--;
        return elements[index];
    }
    public T peek() {
        return elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == size - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyArrayStack (size = " + size + "; " +
                                "top = " + (top == -1 ? "null" : elements[top]) + "): ");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
