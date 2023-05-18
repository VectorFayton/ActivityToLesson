package ProblemB;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        next = null;
    }
}

class LinkedStack<E> {
    private Node<E> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(E e) {
        Node<E> newNode = new Node<>(e);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node<E> temp = top;
        top = top.next;
        size--;
        return temp.data;
    }

    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = top;
        sb.append("[ ");
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private class StackIterator implements Iterator<E> {
        private Node<E> current;

        public StackIterator() {
            current = top;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<E> temp = current;
            current = current.next;
            return temp.data;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (int i = 1; i <= 6; i++) {
            stack.push(i);
            System.out.println(i + "_linkedStack.peek(): " + stack.peek());
            System.out.println(i + "_linkedStack.pop(): " + stack.pop());
            System.out.println(i + "_After pop: " + stack.toString());
        }
        stack.push(25);
        System.out.println("0_After push(25): " + stack.toString());
        stack.push(26);
        System.out.println("1_After push(26): " + stack.toString());
        stack.push(27);
        System.out.println("2_After push(27): " + stack.toString());
        stack.push(28);
        System.out.println("3_After push(28): " + stack.toString());
        stack.push(29);
        System.out.println("4_After push(29): " + stack.toString());
        stack.push(30);
        System.out.println("5_After push(30): " + stack.toString());
        System.out.println(stack.toString());
    }
}

