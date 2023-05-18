import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

class GenericStack<E> {
    private List<E> stack;

    public GenericStack() {
        stack = new ArrayList<>();
    }

    public void push(E element) {
        stack.add(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GenericStack<Integer> stack = new GenericStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(in.nextInt());
        }
        System.out.println("Stack after pushing: " + stack);

        int popped = stack.pop();
        System.out.println("Popped item: " + popped);
        System.out.println("Stack after popping: " + stack);

        int peeked = stack.peek();
        System.out.println("Peeked item: " + peeked);
        System.out.println("Stack after peeking: " + stack);

        int size = stack.size();
        System.out.println("Size of stack: " + size);
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
