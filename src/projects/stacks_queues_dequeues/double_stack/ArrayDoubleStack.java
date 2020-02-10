package projects.stacks_queues_dequeues.double_stack;

public class ArrayDoubleStack<E> implements DoubleStack<E> {
    public static final int CAPACITY = 1000;    // default array capacity
    private E[] data;                           // generic array used for storage
    private int tBlue = -1;                     // index of top element in blue stack
    private int tRed = (CAPACITY / 2) - 1;      // index of top element in red stack

    public ArrayDoubleStack() {
        this(CAPACITY);
    }     // constructs stack with default capacity

    public ArrayDoubleStack(int capacity) {           // constructs stack with given capacity
        data = (E[]) new Object[capacity];      // safe cast; compiler may give warning
    }

    @Override
    public String toString() {
        String blueList = "[";
        String redList = "[";

        if (!isBlueEmpty()) {
            for (int i = 0; i < tBlue + 1; i++) {
                blueList = blueList.concat(data[i] + ", ");
            }
            blueList = blueList.substring(0, blueList.length() - 2);
        }
        if (!isRedEmpty()) {
            for (int j = CAPACITY / 2; j < tRed + 1; j++) {
                redList = redList.concat(data[j] + ", ");
            }
            redList = redList.substring(0, redList.length() - 2);
        }
        blueList = blueList.concat("]");
        redList = redList.concat("]");

        return "ArrayDoubleStack{" +
                "blueStack=" + blueList +
                ", redStack=" + redList +
                "}";
    }

    @Override
    public int redSize() {
        return tRed + 2;
    }

    @Override
    public int blueSize() {
        return tBlue + 2;
    }

    @Override
    public boolean isEmpty() {
        return tBlue + tRed == (CAPACITY / 2) - 2;
    }

    @Override
    public boolean isBlueEmpty() {
        return tBlue == -1;
    }

    @Override
    public boolean isRedEmpty() {
        return tRed == (CAPACITY / 2) - 1;
    }

    /**
     * Adds element e to the blue stack
     *
     * @param e the element to be inserted
     */
    public void bluePush(E e) {
        if (tBlue == CAPACITY / 2 - 1) throw new IllegalStateException("Blue stack is full");
        data[++tBlue] = e;
    }

    /**
     * Returns but does not remove the top element in the blue stack
     *
     * @return Top element in the blue stack
     */
    public E blueTop() {
        if (isBlueEmpty()) return null;
        return data[tBlue];
    }

    @Override
    public E bluePop() {
        return null;
    }

    /**
     * Adds element e to the red stack
     *
     * @param e the element to be inserted
     */
    public void redPush(E e) {
        if (tRed == CAPACITY - 1) throw new IllegalStateException("Red stack is full");
        data[++tRed] = e;
    }

    /**
     * Returns but does not remove the top element in the red stack
     * @return Top element in the red stack
     */
    public E redTop() {
        if (isRedEmpty()) return null;
        return data[tRed];
    }

    @Override
    public E redPop() {
        return null;
    }
}
