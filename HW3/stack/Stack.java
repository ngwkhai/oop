package oop.HW3.stack;

public class Stack<T> {
    private Node<T> top;
    public Stack() {
        this.top = null;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    }
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        Node<T> temp = top;
        int size = 1;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        String s = stack.pop();
        System.out.println(stack.isEmpty());
    }
}
