package ProblemC;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class LinkedStack<E> {

    private StackNode<E> top;
    private int size;
    public LinkedStack() {
        top = null;
        size = 0;
    }

    private static class StackNode<E> {
        private E data;
        private StackNode<E> next;

        public StackNode(E data) {
            this.data = data;
        }

        public StackNode(E element, StackNode<E> next) {
            this.data = element;
            this.next = next;
        }
    }

    public void push(E element) {
        top = new StackNode<>(element, top);
        size++;
    }

    public ListIterator<E> listIterator() {
        return new StackListIterator();
    }

    private class StackListIterator implements ListIterator<E> {
        private StackNode<E> current = top;
        private StackNode<E> previous = null;
        private int previous_location = -1;
        private boolean canRemove = false;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            previous = current;
            previous_location++;
            canRemove = true;
            E data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public boolean hasPrevious() {
            return previous != null;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            current = previous;
            previous = null;
            previous_location--;
            canRemove = true;
            return current.data;
        }

        @Override
        public int nextIndex() {
            return previous_location + 1;
        }

        @Override
        public int previousIndex() {
            return previous_location;
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException();
            }
            if (previous == null) {
                throw new IllegalStateException("You can only remove after calling next() or previous()");
            }
            if (previous_location == 0) {
                top = top.next;
                current = top;
            } else {
                StackNode<E> temp = top;
                for (int i = 0; i < previous_location - 1; i++) {
                    temp = temp.next;
                }
                temp.next = current;
            }
            previous = null;
            previous_location--;
            canRemove = false;
        }

        @Override
        public void set(E e) {
            if (!canRemove) {
                throw new IllegalStateException();
            }
            if (previous == null) {
                throw new IllegalStateException("You can only set after calling next() or previous()");
            }
            previous.data = e;
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException("You can only access the top element in the stack!");
        }
    }
}

public class Main extends LinkedList {
    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(25);
        linkedStack.push(26);
        linkedStack.push(27);
        linkedStack.push(28);
        linkedStack.push(29);
        linkedStack.push(30);

        ListIterator<Integer> listIterator = linkedStack.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.nextIndex() + "_" + listIterator.next() + " ");
        }
        System.out.println();
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previousIndex() + "_" + listIterator.previous() + " ");
        }
        System.out.println();
    }

}
