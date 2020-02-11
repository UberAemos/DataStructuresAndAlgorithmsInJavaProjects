package projects.stacks_queues_dequeues;

import base.stacks_queues_dequeues.ArrayStack;

/**
 * Array based stack implementation that replaces the last element when the capacity is full
 */
public class LeakyStack<E> extends ArrayStack<E> {
    private int size = 0;

    public LeakyStack() {
        super();
    }

    public LeakyStack(int capacity) {
        super(capacity);
    }

    /**
     * Inserts e to the stack, if the stack capacity is full removes the oldest element from the stack
     * @param e the element to be inserted
     */
    public void push(E e) {
        t = (t + 1) % data.length;
        data[t] = e;
        if (size < data.length) size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stack = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int currentIndex = t - i;
            currentIndex = (currentIndex < 0) ? currentIndex + size : currentIndex;
            stack.append(data[currentIndex]).append(", ");
        }
        stack.delete(stack.length() - 2, stack.length());
        stack.append("]");
        return stack.toString();
    }
}
