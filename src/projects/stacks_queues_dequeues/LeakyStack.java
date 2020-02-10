package projects.stacks_queues_dequeues;

import base.stacks_queues_dequeues.Stack;

import static base.stacks_queues_dequeues.ArrayStack.CAPACITY;

/**
 * Array based stack implementation that replaces the last element when the capacity is full
 */
public class LeakyStack<E> implements Stack<E> {
    //instance variable
    private E[] data;       // generic array used for storage
    private int f = 0;      // index of the front element
    private int sz = 0;     // current number of elements

    // constructors
    public LeakyStack() {
        this(CAPACITY);
    }       // constructs queue with default capacity

    /**
     * Construct queue with given capacity
     *
     * @param capacity
     */
    public LeakyStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * Returns the number of elements in the stack.
     */
    public int size() {
        return sz;
    }

    /**
     * Tests whether the stack is empty.
     */
    public boolean isEmpty() {
        return sz == 0;
    }

    /**
     * Pushes e to the top of the list, if the stack is full then removes the bottom element
     *
     * @param e the element to be inserted
     */
    public void push(E e) {
        data[f++] = e;
    }

    @Override
    public E top() {
        return null;
    }

    @Override
    public E pop() {
        return null;
    }
}
