package projects.stacks_queues_dequeues.double_stack;

/**
 * A two-color, double-stack that consists of two stacks— one “red” and one “blue” and has as its operations
 * color-coded versions of the regular stack
 */
public interface DoubleStack<E> {
    /**
     * Returns the number of red elements in the stack.
     *
     * @return number of red elements in the stack
     */
    int redSize();

    /**
     * Returns the number of blue elements in the stack.
     *
     * @return number of blue elements in the stack
     */
    int blueSize();

    /**
     * Tests whether the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Tests whether the blue stack is empty.
     *
     * @return true if the blue stack is empty, false otherwise.
     */
    boolean isBlueEmpty();

    /**
     * Tests whether the red stack is empty.
     *
     * @return true if the red stack is empty, false otherwise.
     */
    boolean isRedEmpty();

    /**
     * Inserts an elements at the top of the blue stack.
     *
     * @param e the element to be inserted
     */
    void bluePush(E e);

    /**
     * Returns, but does not remove, the element at the top of the blue stack.
     *
     * @return top element in the stack (or null if empty)
     */
    E blueTop();

    /**
     * Removes and returns the top element from the blue stack.
     *
     * @return element removed (or null if empty)
     */
    E bluePop();

    /**
     * Inserts an elements at the top of the red stack.
     *
     * @param e the element to be inserted
     */
    void redPush(E e);

    /**
     * Returns, but does not remove, the element at the top of the red stack.
     *
     * @return top element in the stack (or null if empty)
     */
    E redTop();

    /**
     * Removes and returns the top element from the red stack.
     *
     * @return element removed (or null if empty)
     */
    E redPop();
}
